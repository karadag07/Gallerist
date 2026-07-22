package com.karadag.galeri.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorObject {// Client'a hatanın hangi formatta (status, message, path, timestamp) döneceğini
                          // belirleyen zarf sınıfı.

    private int status;

    // BaseException'ın taşıdığı, ErrorMessage.prepareErrorMessage()'dan gelen hazır
    // mesaj
    private String message;

    private String path;

    private Date timestamp;
}