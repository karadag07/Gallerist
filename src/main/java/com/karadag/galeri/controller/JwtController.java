package com.karadag.galeri.controller;

import org.springframework.web.bind.annotation.RestController;

import com.karadag.galeri.controller.IController.IJwtController;
import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestLogin;
import com.karadag.galeri.dto.RequestRegister;
import com.karadag.galeri.dto.ResponseToken;
import com.karadag.galeri.entity.RefreshToken;
import com.karadag.galeri.service.IService.ILoginService;
import com.karadag.galeri.service.IService.IRefreshTokenService;
import com.karadag.galeri.service.IService.IRegisterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JwtController implements IJwtController {

    private final IRegisterService registerService;
    private final ILoginService loginService;
    private final IRefreshTokenService refreshTokenService;

    @Override
    public OkResponse<ResponseToken> register(RequestRegister request) {
        return OkResponse.ok(registerService.register(request));
    }

    @Override
    public OkResponse<ResponseToken> login(RequestLogin request) {
        return OkResponse.ok(loginService.login(request));

    }

    @Override
    public OkResponse<ResponseToken> generateAccessTokenFromRefreshToken(RefreshToken sendedRefreshToken) {
        return OkResponse.ok(refreshTokenService.generateAccessTokenFromRefreshToken(sendedRefreshToken));
    }

}
