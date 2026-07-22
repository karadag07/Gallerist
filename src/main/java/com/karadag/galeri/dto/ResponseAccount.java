package com.karadag.galeri.dto;

import com.karadag.galeri.enums.CurrencyType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAccount {
    private String accountNo;
    private CurrencyType currencyType;

}
