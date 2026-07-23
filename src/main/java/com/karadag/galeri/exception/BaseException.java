package com.karadag.galeri.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {// ErrorMessage'ı alıp gerçek bir RuntimeException'a çeviren, kod
                                                     // içinde throw new BaseException(...) şeklinde fırlatacağın tek
                                                     // özel exception sınıfı.

    private final HttpStatus httpStatus;

    public BaseException(ErrorDetails errorDetails) {
        super(errorDetails.addDetailToErrorMessage());
        this.httpStatus = errorDetails.getMessageType().getHttpStatus();
    }

}

// MessageType (hangi hata) → ErrorMessage (mesajı hazırla)
// → BaseException (fırlat) → GlobalExceptionHandler (yakala) → ErrorObject
// (client'a bu formatta dön)
