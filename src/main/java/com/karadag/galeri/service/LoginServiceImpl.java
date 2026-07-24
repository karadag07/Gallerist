package com.karadag.galeri.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.karadag.galeri.dto.RequestLogin;
import com.karadag.galeri.dto.ResponseToken;
import com.karadag.galeri.entity.User;
import com.karadag.galeri.enums.MessageType;
import com.karadag.galeri.exception.BaseException;
import com.karadag.galeri.exception.ErrorDetails;
import com.karadag.galeri.service.IService.IAccessTokenService;
import com.karadag.galeri.service.IService.ILoginService;
import com.karadag.galeri.service.IService.IRefreshTokenService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements ILoginService {
    private final AuthenticationManager authenticationManager;
    private final IAccessTokenService accessTokenService;
    private final IRefreshTokenService refreshTokenService;

    @Override
    public ResponseToken login(RequestLogin request) {
        try {
            Authentication auth = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            User user = (User) auth.getPrincipal();

            String accessToken = accessTokenService.generateAccessToken(user);
            String refreshToken = refreshTokenService.generateRefreshToken(user).getRefreshToken();

            return new ResponseToken(accessToken, refreshToken);
        } catch (BadCredentialsException | UsernameNotFoundException ex) {
            throw new BaseException(
                    new ErrorDetails(MessageType.USERNAME_OR_PASSWORD_INVALID, "kullanıcı adı veya şifre hatalı"));
        }
    }

}
