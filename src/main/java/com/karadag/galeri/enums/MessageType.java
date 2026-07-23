package com.karadag.galeri.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum MessageType {// Projede olabilecek tüm hata türlerinin, kod + mesaj olarak listelendiği
                         // katalog
    NO_RECORD_EXIST("1004", "kayıt bulunamadı"), // Nesne ararken
    TOKEN_IS_EXPIRED("1005", "tokenın süresi bitmiştir"),
    USERNAME_NOT_FOUND("1006", "username bulunamadı"),
    USERNAME_OR_PASSWORD_INVALID("1007", "kullanıcı adı veya şifre hatalı"),
    REFRESH_TOKEN_NOT_FOUND("1008", "refresh token bulunamadı"),
    REFRESH_TOKEN_IS_EXPIRED("1009", "refresh tokenın süresi bitmiştir"),
    CURRENY_RATES_IS_OCCURED("1010", "döviz kuru alınamadı"),
    CUSTOMER_AMOUNT_IS_NOT_ENOUGH("1011", "müşterinin parası yeterli değildir"), // musterının bakıyesı yeterlı olmalı
    CAR_STATUS_IS_ALREADY_SALED("1012", "araba satılmış göründüğü için satılamaz"), // arabanın satılmamıs olması lazım
    GENERAL_EXCEPTION("9999", "genel bir hata oluştu"),
    USERNAME_ALREADY_EXISTS("1013", "username kullanılmaktadır"),
    TOKEN_IS_INVALID("1014", "geçersiz token"),
    AUTHENTICATION_REQUIRED("1015", "bu işlem için giriş yapmanız gerekmektedir"),;

    private String code;
    private String message;

}
