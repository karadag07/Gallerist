package com.karadag.galeri.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karadag.galeri.dto.CurrencyRatesResponse;
import com.karadag.galeri.dto.RequestSaledCar;
import com.karadag.galeri.dto.ResponseSaledCar;
import com.karadag.galeri.entity.Account;
import com.karadag.galeri.entity.Car;
import com.karadag.galeri.entity.Customer;
import com.karadag.galeri.entity.Gallerist;
import com.karadag.galeri.entity.SaledCar;
import com.karadag.galeri.enums.CarStatusType;
import com.karadag.galeri.enums.CurrencyType;
import com.karadag.galeri.enums.MessageType;
import com.karadag.galeri.exception.BaseException;
import com.karadag.galeri.exception.ErrorDetails;
import com.karadag.galeri.mapper.SaledCarMapper;
import com.karadag.galeri.repository.CarRepository;
import com.karadag.galeri.repository.CustomerRepository;
import com.karadag.galeri.repository.GalleristRepository;
import com.karadag.galeri.repository.SaledCarRepository;
import com.karadag.galeri.service.IService.ICurrencyRatesService;
import com.karadag.galeri.service.IService.ISaledCarService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SaledCarServiceImpl implements ISaledCarService {

        private final CustomerRepository customerRepository;
        private final CarRepository carRepository;
        private final GalleristRepository galleristRepository;
        private final SaledCarRepository saledCarRepository;
        private final SaledCarMapper saledCarMapper;
        private final ICurrencyRatesService currencyRatesService;

        @Override
        public ResponseSaledCar saveSaledCar(RequestSaledCar request) {
                Gallerist gallerist = galleristRepository.findById(request.getGalleristId())
                                .orElseThrow(() -> new BaseException(
                                                new ErrorDetails(MessageType.NO_RECORD_EXIST, "gallerist")));

                Car car = carRepository.findById(request.getCarId())
                                .orElseThrow(() -> new BaseException(
                                                new ErrorDetails(MessageType.NO_RECORD_EXIST, "car")));

                Customer customer = customerRepository.findById(request.getCustomerId())
                                .orElseThrow(() -> new BaseException(
                                                new ErrorDetails(MessageType.NO_RECORD_EXIST, "customer")));

                if (isSaledCar(car)) {// Araba satıldı mı kontrolu, satıldıysa exception fırlat
                        throw new BaseException(
                                        new ErrorDetails(MessageType.CAR_STATUS_IS_ALREADY_SALED, "car is saled"));
                }

                BigDecimal carPrice = checkCurrency(car, customer.getAccount());

                if (!isEnoughMoney(customer, carPrice)) {// Customerın parası yeterlı mı, yeterli değilse exception
                                                         // fırlat
                        throw new BaseException(new ErrorDetails(MessageType.CUSTOMER_AMOUNT_IS_NOT_ENOUGH,
                                        "money is not enough"));
                }

                SaledCar saledCar = saledCarMapper.toEntity(car, customer, gallerist);
                SaledCar savedSaledCar = saledCarRepository.save(saledCar);// Araba satısı yapılmıstır

                BigDecimal remainingBalance = customer.getAccount().getBalance().subtract(carPrice);
                customer.getAccount().setBalance(remainingBalance);// customerın hesabından araba parasını düş
                customerRepository.save(customer);

                car.setCarStatusType(CarStatusType.SALE);// arabayı satılmıs olarak ısaretle
                carRepository.save(car);// ve aracı guncelle

                return saledCarMapper.toResponse(savedSaledCar);
        }

        public BigDecimal checkCurrency(Car car, Account account) {
                if (car.getCurrencyType() == account.getCurrencyType()) {// doviz cesitleri aynıysa dırekt cık
                        return car.getPrice();
                }

                // buraya kadar geldıysen demek ki car ile account dovız turlerı farklı

                String today = getToday();// istek atacagımız api için parametre
                // bankaya istek at
                CurrencyRatesResponse response = currencyRatesService.getCurrencyRates(today, today);
                // bankadan gelen cevaptaki usd yi ayıkla
                BigDecimal usd = new BigDecimal(response.getItems().get(0).getUsd());

                if (car.getCurrencyType() == CurrencyType.USD) {// eger değeri usd ise tl ye cevir
                        return car.getPrice().multiply(usd);
                } else {
                        return car.getPrice().divide(usd, 2, RoundingMode.HALF_UP);// eğer degeri tl ise dolara cevır
                }

        }

        public boolean isSaledCar(Car car) {
                return car.getCarStatusType() == CarStatusType.SALE;
        }

        public boolean isEnoughMoney(Customer customer, BigDecimal carPrice) {
                return customer.getAccount().getBalance().compareTo(carPrice) >= 0;
        }

        private String getToday() {
                return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        }

}
