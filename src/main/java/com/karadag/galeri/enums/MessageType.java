package com.karadag.galeri.enums;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum MessageType {
    NO_RECORD_EXIST("1004", "kayıt bulunamadı", HttpStatus.NOT_FOUND),
    TOKEN_IS_EXPIRED("1005", "tokenın süresi bitmiştir", HttpStatus.UNAUTHORIZED),
    USERNAME_NOT_FOUND("1006", "username bulunamadı", HttpStatus.NOT_FOUND),
    USERNAME_OR_PASSWORD_INVALID("1007", "kullanıcı adı veya şifre hatalı", HttpStatus.UNAUTHORIZED),
    REFRESH_TOKEN_NOT_FOUND("1008", "refresh token bulunamadı", HttpStatus.NOT_FOUND),
    REFRESH_TOKEN_IS_EXPIRED("1009", "refresh tokenın süresi bitmiştir", HttpStatus.UNAUTHORIZED),
    CURRENY_RATES_IS_OCCURED("1010", "döviz kuru alınamadı", HttpStatus.INTERNAL_SERVER_ERROR),
    CUSTOMER_AMOUNT_IS_NOT_ENOUGH("1011", "müşterinin parası yeterli değildir", HttpStatus.BAD_REQUEST),
    CAR_STATUS_IS_ALREADY_SALED("1012", "araba satılmış göründüğü için satılamaz", HttpStatus.CONFLICT),
    GENERAL_EXCEPTION("9999", "genel bir hata oluştu", HttpStatus.INTERNAL_SERVER_ERROR),
    USERNAME_ALREADY_EXISTS("1013", "username kullanılmaktadır", HttpStatus.CONFLICT),
    TOKEN_IS_INVALID("1014", "geçersiz token", HttpStatus.UNAUTHORIZED),
    AUTHENTICATION_REQUIRED("1015", "bu işlem için giriş yapmanız gerekmektedir", HttpStatus.UNAUTHORIZED);

    private String code;
    private String message;
    private HttpStatus httpStatus;
}