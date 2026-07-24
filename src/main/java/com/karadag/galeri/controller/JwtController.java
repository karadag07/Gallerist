package com.karadag.galeri.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karadag.galeri.controller.IController.IJwtController;
import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestLogin;
import com.karadag.galeri.dto.RequestRefreshToken;
import com.karadag.galeri.dto.RequestRegister;
import com.karadag.galeri.dto.ResponseToken;
import com.karadag.galeri.dto.ResponseUser;
import com.karadag.galeri.dto.UpdateRoleRequest;
import com.karadag.galeri.service.UpdateRoleService;
import com.karadag.galeri.service.IService.ILoginService;
import com.karadag.galeri.service.IService.IRefreshTokenService;
import com.karadag.galeri.service.IService.IRegisterService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JwtController implements IJwtController {

    private final IRegisterService registerService;
    private final ILoginService loginService;
    private final IRefreshTokenService refreshTokenService;
    private final UpdateRoleService updateRoleService;

    @PostMapping("/auth/register")
    @Override
    public OkResponse<ResponseToken> register(@RequestBody @Valid RequestRegister request) {
        return OkResponse.ok(registerService.register(request));
    }

    @PostMapping("/auth/login")
    @Override
    public OkResponse<ResponseToken> login(@RequestBody @Valid RequestLogin request) {
        return OkResponse.ok(loginService.login(request));

    }

    @PostMapping("/auth/refresh")
    @Override
    public OkResponse<ResponseToken> generateAccessTokenFromRefreshToken(
            @RequestBody RequestRefreshToken sendedRefreshToken) {
        return OkResponse.ok(refreshTokenService.generateAccessTokenFromRefreshToken(sendedRefreshToken));
    }

    @PutMapping("/user/{id}/role")
    public OkResponse<ResponseUser> updateRole(@PathVariable(name = "id") Long id,
            @RequestBody UpdateRoleRequest request) {
        return OkResponse.ok(updateRoleService.updateRole(id, request));
    }

}
