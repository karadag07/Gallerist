package com.karadag.galeri.service;

import org.springframework.stereotype.Service;

import com.karadag.galeri.dto.RequestCar;
import com.karadag.galeri.dto.ResponseCar;
import com.karadag.galeri.entity.Car;
import com.karadag.galeri.mapper.CarMapper;
import com.karadag.galeri.repository.CarRepository;
import com.karadag.galeri.service.IService.ICarService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements ICarService {
    private final CarMapper carMapper;
    private final CarRepository carRepository;

    @Override
    public ResponseCar saveCar(RequestCar request) {
        Car car = carMapper.toEntity(request);

        Car savedCar = carRepository.save(car);

        return carMapper.toResponse(savedCar);
    }

}
