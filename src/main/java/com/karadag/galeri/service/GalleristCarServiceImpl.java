package com.karadag.galeri.service;

import org.springframework.stereotype.Service;

import com.karadag.galeri.dto.RequestGalleristCar;
import com.karadag.galeri.dto.ResponseGalleristCar;
import com.karadag.galeri.entity.Car;
import com.karadag.galeri.entity.Gallerist;
import com.karadag.galeri.entity.GalleristCar;
import com.karadag.galeri.enums.MessageType;
import com.karadag.galeri.exception.BaseException;
import com.karadag.galeri.exception.ErrorMessage;
import com.karadag.galeri.mapper.GalleristCarMapper;
import com.karadag.galeri.repository.CarRepository;
import com.karadag.galeri.repository.GalleristCarRepository;
import com.karadag.galeri.repository.GalleristRepository;
import com.karadag.galeri.service.IService.IGalleristCarService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GalleristCarServiceImpl implements IGalleristCarService {

        private final GalleristCarRepository galleristCarRepository;
        private final GalleristRepository galleristRepository;
        private final CarRepository carRepository;
        private final GalleristCarMapper galleristCarMapper;

        @Override
        public ResponseGalleristCar saveGalleristCar(RequestGalleristCar request) {// Zaten var olan gallerist ile car ı
                                                                                   // galleristCar nesnesıne
                                                                                   // baglayacagız
                Gallerist gallerist = galleristRepository.findById(request.getGalleristId())
                                .orElseThrow(() -> new BaseException(
                                                new ErrorMessage(MessageType.NO_RECORD_EXIST, "gallerist")));

                Car car = carRepository.findById(request.getCarId())
                                .orElseThrow(() -> new BaseException(
                                                new ErrorMessage(MessageType.NO_RECORD_EXIST, "car")));

                GalleristCar galleristCar = galleristCarMapper.toEntity(gallerist, car);

                GalleristCar savedGalleristCar = galleristCarRepository.save(galleristCar);

                return galleristCarMapper.toResponse(savedGalleristCar);

        }

}
