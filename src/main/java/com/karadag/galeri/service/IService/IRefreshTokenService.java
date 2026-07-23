package com.karadag.galeri.service.IService;

import com.karadag.galeri.dto.RequestRefreshToken;
import com.karadag.galeri.dto.ResponseToken;
import com.karadag.galeri.entity.RefreshToken;
import com.karadag.galeri.entity.User;

public interface IRefreshTokenService {
    ResponseToken generateAccessTokenFromRefreshToken(RequestRefreshToken sendedRefreshToken);

    RefreshToken generateRefreshToken(User user);

    boolean isRefreshTokenExpired(RefreshToken refreshToken);

}
