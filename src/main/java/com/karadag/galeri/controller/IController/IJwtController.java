package com.karadag.galeri.controller.IController;

import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestLogin;
import com.karadag.galeri.dto.RequestRegister;
import com.karadag.galeri.dto.ResponseToken;
import com.karadag.galeri.entity.RefreshToken;

public interface IJwtController {

    public OkResponse<ResponseToken> register(RequestRegister request);

    public OkResponse<ResponseToken> login(RequestLogin request);

    public OkResponse<ResponseToken> generateAccessTokenFromRefreshToken(RefreshToken sendedRefreshToken);
}
