package com.karadag.galeri.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karadag.galeri.controller.IController.IGalleristController;
import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestGallerist;
import com.karadag.galeri.dto.ResponseGallerist;
import com.karadag.galeri.service.IService.IGalleristService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GalleristController implements IGalleristController {

    private final IGalleristService galleristService;

    @PostMapping("/gallerist")
    @Override
    public OkResponse<ResponseGallerist> saveGallerist(@RequestBody @Valid RequestGallerist gallerist) {
        return OkResponse.ok(galleristService.saveGallerist(gallerist));
    }
}
