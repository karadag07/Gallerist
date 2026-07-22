package com.karadag.galeri.dto;

import java.util.List;

import lombok.Data;

@Data
public class CurrencyRatesResponse {
    private Integer totalCount;
    private List<CurrencyItems> items;
}