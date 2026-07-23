package com.karadag.galeri.controller.IController;

import com.karadag.galeri.dto.CurrencyRatesResponse;
import com.karadag.galeri.dto.OkResponse;

public interface ICurrencyController {
    public OkResponse<CurrencyRatesResponse> getCurrencyRates(String startDate, String endDate);
}
