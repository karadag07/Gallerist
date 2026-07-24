package com.karadag.galeri.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karadag.galeri.controller.IController.IGalleristCarControllar;
import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestGalleristCar;
import com.karadag.galeri.dto.ResponseGalleristCar;
import com.karadag.galeri.service.IService.IGalleristCarService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GalleristCarController implements IGalleristCarControllar {
    private final IGalleristCarService galleristCarService;

    @PostMapping("/galleristCar")
    @Override
    public OkResponse<ResponseGalleristCar> saveGalleristCar(@RequestBody @Valid RequestGalleristCar galleristCar) {
        return OkResponse.ok(galleristCarService.saveGalleristCar(galleristCar));
    }
}
