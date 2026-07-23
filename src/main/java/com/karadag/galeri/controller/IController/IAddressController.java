package com.karadag.galeri.controller.IController;

import org.springframework.web.bind.annotation.RequestBody;

import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestAddress;
import com.karadag.galeri.dto.ResponseAddress;

import jakarta.validation.Valid;

public interface IAddressController {
    public OkResponse<ResponseAddress> saveAddress(@RequestBody @Valid RequestAddress address);
}
