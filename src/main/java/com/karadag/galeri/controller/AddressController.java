package com.karadag.galeri.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karadag.galeri.controller.IController.IAddressController;
import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestAddress;
import com.karadag.galeri.dto.ResponseAddress;
import com.karadag.galeri.service.IService.IAddressService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AddressController implements IAddressController {
    private final IAddressService addressService;

    @PostMapping("/address")
    @Override
    public OkResponse<ResponseAddress> saveAddress(@RequestBody @Valid RequestAddress address) {
        return OkResponse.ok(addressService.saveAddress(address));
    }
}
