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
public class ErrorMessage {// MessageType'tan seçilen hatayı alıp, isteğe bağlı bir detay ("gallerist"
                           // gibi) ekleyerek son mesajı üreten ara sınıf.

    private MessageType messageType;

    private String detail;

    public String prepareErrorMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(messageType.getMessage());

        if (this.detail != null) {
            builder.append(" : ").append(detail);
        }

        return builder.toString();
    }
}