package com.karadag.galeri.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.karadag.galeri.dto.RequestRegister;
import com.karadag.galeri.dto.ResponseToken;
import com.karadag.galeri.entity.User;
import com.karadag.galeri.enums.MessageType;
import com.karadag.galeri.enums.RoleType;
import com.karadag.galeri.exception.BaseException;
import com.karadag.galeri.exception.ErrorDetails;
import com.karadag.galeri.repository.UserRepository;
import com.karadag.galeri.service.IService.IAccessTokenService;
import com.karadag.galeri.service.IService.IRefreshTokenService;
import com.karadag.galeri.service.IService.IRegisterService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements IRegisterService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final IAccessTokenService accessTokenService;
    private final IRefreshTokenService refreshTokenService;

    @Override
    public ResponseToken register(RequestRegister request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new BaseException(new ErrorDetails(MessageType.USERNAME_ALREADY_EXISTS, "Username kullaniliyor"));
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(RoleType.USER);
        userRepository.save(user);

        String accessToken = accessTokenService.generateAccessToken(user);
        String refreshToken = refreshTokenService.generateRefreshToken(user).getRefreshToken();

        return new ResponseToken(accessToken, refreshToken);
    }
}
