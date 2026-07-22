package com.karadag.galeri.exception;

public class BaseException extends RuntimeException {// ErrorMessage'ı alıp gerçek bir RuntimeException'a çeviren, kod
                                                     // içinde throw new BaseException(...) şeklinde fırlatacağın tek
                                                     // özel exception sınıfı.

    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage());
    }
}

// MessageType (hangi hata) → ErrorMessage (mesajı hazırla)
// → BaseException (fırlat) → GlobalExceptionHandler (yakala) → ErrorObject
// (client'a bu formatta dön)