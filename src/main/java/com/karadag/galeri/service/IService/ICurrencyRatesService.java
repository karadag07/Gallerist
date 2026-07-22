package com.karadag.galeri.service.IService;

import com.karadag.galeri.dto.CurrencyRatesResponse;

public interface ICurrencyRatesService {
    CurrencyRatesResponse getCurrencyRates(String startDate, String endDate);
}