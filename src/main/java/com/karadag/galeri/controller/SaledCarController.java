package com.karadag.galeri.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karadag.galeri.controller.IController.ISaledCarController;
import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestSaledCar;
import com.karadag.galeri.dto.ResponseSaledCar;
import com.karadag.galeri.service.IService.ISaledCarService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SaledCarController implements ISaledCarController {
    private final ISaledCarService saledCarService;

    @PostMapping("saledCar")
    @Override
    public OkResponse<ResponseSaledCar> saveSaledCar(@RequestBody @Valid RequestSaledCar saledCar) {
        return OkResponse.ok(saledCarService.saveSaledCar(saledCar));
    }
}
