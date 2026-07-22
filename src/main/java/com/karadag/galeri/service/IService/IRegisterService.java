package com.karadag.galeri.service.IService;

import com.karadag.galeri.dto.RequestRegister;
import com.karadag.galeri.dto.ResponseToken;

public interface IRegisterService {
    public ResponseToken register(RequestRegister requst);
}
