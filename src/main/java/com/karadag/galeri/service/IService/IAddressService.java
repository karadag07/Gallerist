package com.karadag.galeri.service.IService;

import com.karadag.galeri.dto.RequestAddress;
import com.karadag.galeri.dto.ResponseAddress;

public interface IAddressService {

    ResponseAddress saveAddress(RequestAddress request);
}
