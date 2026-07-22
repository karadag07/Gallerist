package com.karadag.galeri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Register (ve login) başarılı olduğunda client'a dönülecek response.
// Login akışında da muhtemelen aynı sınıfı kullanıyorsundur.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseToken {
    private String accessToken;
    private String refreshToken;

}