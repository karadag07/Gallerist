package com.karadag.galeri.service.IService;

import com.karadag.galeri.dto.ResponseToken;
import com.karadag.galeri.entity.RefreshToken;
import com.karadag.galeri.entity.User;

public interface IRefreshTokenService {
    ResponseToken generateAccessTokenFromRefreshToken(RefreshToken sendedRefreshToken);

    RefreshToken generateRefreshToken(User user);

    boolean isRefreshTokenExpired(RefreshToken refreshToken);

}
