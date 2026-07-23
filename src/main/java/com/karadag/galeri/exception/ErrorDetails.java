package com.karadag.galeri.exception;

import com.karadag.galeri.enums.MessageType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {// MessageType'tan seçilen hatayı alıp, isteğe bağlı bir detay ("gallerist"
                           // gibi) ekleyerek son mesajı üreten ara sınıf.
    private MessageType messageType;
    private String detail;

    public String addDetailToErrorMessage() {
        return detail == null
                ? messageType.getMessage()
                : messageType.getMessage() + " : " + detail;
    }
}