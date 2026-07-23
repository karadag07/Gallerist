package com.karadag.galeri.config;

import java.io.IOException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.karadag.galeri.enums.MessageType;
import com.karadag.galeri.exception.ErrorObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        String authError = (String) request.getAttribute("authError");
        MessageType messageType;

        if ("TOKEN_EXPIRED".equals(authError)) {
            messageType = MessageType.TOKEN_IS_EXPIRED;
        } else if ("TOKEN_INVALID".equals(authError)) {
            messageType = MessageType.TOKEN_IS_INVALID;
        } else {
            messageType = MessageType.AUTHENTICATION_REQUIRED; // token hiç yok / hiç gönderilmemiş
        }

        ErrorObject error = new ErrorObject(
                HttpStatus.UNAUTHORIZED.value(),
                MessageType.USERNAME_OR_PASSWORD_INVALID.getMessage(),
                request.getServletPath(),
                new Date());

        objectMapper.writeValue(response.getOutputStream(), error);
    }
}