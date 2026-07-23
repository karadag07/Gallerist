package com.karadag.galeri.service.IService;

import com.karadag.galeri.dto.RequestLogin;
import com.karadag.galeri.dto.ResponseToken;

public interface ILoginService {
    public ResponseToken login(RequestLogin request);
}
