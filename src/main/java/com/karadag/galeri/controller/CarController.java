package com.karadag.galeri.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karadag.galeri.controller.IController.ICarController;
import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestCar;
import com.karadag.galeri.dto.ResponseCar;
import com.karadag.galeri.service.IService.ICarService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CarController implements ICarController {
    private final ICarService carService;

    @PostMapping("/car")
    @Override
    public OkResponse<ResponseCar> saveCar(@RequestBody @Valid RequestCar car) {
        return OkResponse.ok(carService.saveCar(car));
    }
}
