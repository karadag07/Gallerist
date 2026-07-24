package com.karadag.galeri.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.karadag.galeri.dto.CurrencyRatesResponse;
import com.karadag.galeri.enums.MessageType;
import com.karadag.galeri.exception.BaseException;
import com.karadag.galeri.exception.ErrorDetails;
import com.karadag.galeri.service.IService.ICurrencyRatesService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements ICurrencyRatesService {
    private static final String API_KEY = "mKidIstP78";

    @Override
    public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate) {
        String endpoint = "https://evds3.tcmb.gov.tr/igmevdsms-dis/series=TP.DK.USD.A"
                + "&startDate=" + startDate + "&endDate=" + endDate + "&type=json";// URL İSTEK LİNKİMİZİN KALIP FORMATI

        try {
            RestClient request = RestClient.create();

            CurrencyRatesResponse response = request.get()
                    .uri(endpoint)
                    .header("key", API_KEY)
                    .retrieve()
                    .body(CurrencyRatesResponse.class);

            if (response == null || response.getItems() == null || response.getItems().isEmpty()) {
                throw new BaseException(
                        new ErrorDetails(MessageType.CURRENY_RATES_IS_OCCURED, "kur bilgisi alinamadi"));

            }
            return response;
        } catch (Exception ex) {
            throw new BaseException(
                    new ErrorDetails(MessageType.CURRENY_RATES_IS_OCCURED, "karsi sunucuda sorun cikti"));
        }
    }

}
