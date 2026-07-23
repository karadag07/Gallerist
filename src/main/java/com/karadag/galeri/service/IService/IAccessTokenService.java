package com.karadag.galeri.service.IService;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;

import com.karadag.galeri.entity.User;

import io.jsonwebtoken.Claims;

public interface IAccessTokenService {
    SecretKey getKey();

    String generateAccessToken(User user);

    <T> T exportToken(String token, Function<Claims, T> func);

    String getUsername(String token);

    Date getExpirationDate(String token);

    boolean isTokenExpired(String token);

    boolean isTokenValid(String token, UserDetails user);
}
