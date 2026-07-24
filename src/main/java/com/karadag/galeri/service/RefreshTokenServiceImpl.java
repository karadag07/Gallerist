package com.karadag.galeri.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.karadag.galeri.dto.RequestRefreshToken;
import com.karadag.galeri.dto.ResponseToken;
import com.karadag.galeri.entity.RefreshToken;
import com.karadag.galeri.entity.User;
import com.karadag.galeri.enums.MessageType;
import com.karadag.galeri.exception.BaseException;
import com.karadag.galeri.exception.ErrorDetails;
import com.karadag.galeri.repository.RefreshTokenRepository;
import com.karadag.galeri.service.IService.IRefreshTokenService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements IRefreshTokenService {
    private final AccessTokenServiceImpl accessTokenService;
    private final RefreshTokenRepository refreshTokenRepository;

    public ResponseToken generateAccessTokenFromRefreshToken(RequestRefreshToken sendedRefreshToken) {
        RefreshToken refreshToken = refreshTokenRepository.findByRefreshToken(sendedRefreshToken.getRefreshToken())
                .orElseThrow(() -> new BaseException(
                        new ErrorDetails(MessageType.REFRESH_TOKEN_NOT_FOUND, "gonderilen refresh token bulunamadi")));

        if (isRefreshTokenExpired(refreshToken)) {
            refreshTokenRepository.delete(refreshToken);
            throw new BaseException(
                    new ErrorDetails(MessageType.REFRESH_TOKEN_IS_EXPIRED, "refrest tokenin suresi dolmustur"));
        }

        User user = refreshToken.getUser();

        String accessToken = accessTokenService.generateAccessToken(user);
        String refreshTokenResponse = refreshToken.getRefreshToken();

        return new ResponseToken(accessToken, refreshTokenResponse);

    }

    /***********************************************************/
    public RefreshToken generateRefreshToken(User user) {

        refreshTokenRepository.findByUser(user).ifPresent(refreshTokenRepository::delete);// eski tokenı sil

        RefreshToken refreshToken = RefreshToken.builder()// yenı refresh ı olustur
                .refreshToken(UUID.randomUUID().toString())
                .expiredDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 60))
                .user(user)
                .build();

        return refreshTokenRepository.save(refreshToken);
    }

    public boolean isRefreshTokenExpired(RefreshToken refreshToken) {
        return new Date().after(refreshToken.getExpiredDate());// suanki zamandan önceyse true (yanı token suresı
                                                               // bıtmıs)
                                                               // suanki zamandan sonraysa false(yanı token suresı var
                                                               // hala)
    }

}
