package com.karadag.galeri.service;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.karadag.galeri.entity.User;
import com.karadag.galeri.service.IService.IAccessTokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class AccessTokenServiceImpl implements IAccessTokenService {

    private final static String SECRET_KEY = "d0b1a8a8bf1e167861ab34e8374316bc102392a99078d8a0a52f87eaa5656f75";

    public SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(User user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getKey())
                .compact();
    }

    public <T> T exportToken(String token, Function<Claims, T> func) {
        Claims claim = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return func.apply(claim);
    }

    public String getUsername(String token) {
        return exportToken(token, Claims::getSubject);
    }

    public Date getExpirationDate(String token) {
        return exportToken(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token) {
        return getExpirationDate(token).before(new Date());
    }

    public boolean isTokenValid(String token, UserDetails user) {
        String username = user.getUsername();
        return username.equals(getUsername(token)) && !isTokenExpired(token);
    }

}
