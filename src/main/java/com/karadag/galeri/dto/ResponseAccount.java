package com.karadag.galeri.dto;

import java.math.BigDecimal;

import com.karadag.galeri.enums.CurrencyType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAccount {
    private String accountNo;
    private String iban;
    private BigDecimal balance;
    private CurrencyType currencyType;
}