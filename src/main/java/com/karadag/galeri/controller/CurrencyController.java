package com.karadag.galeri.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karadag.galeri.controller.IController.ICurrencyController;
import com.karadag.galeri.dto.CurrencyRatesResponse;
import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.service.IService.ICurrencyRatesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CurrencyController implements ICurrencyController {

    private final ICurrencyRatesService currencyRatesService;

    @GetMapping("/getCurrency")
    @Override
    public OkResponse<CurrencyRatesResponse> getCurrencyRates(@RequestParam("starDate") String startDate,
            @RequestParam("endDate") String endDate) {
        return OkResponse.ok(currencyRatesService.getCurrencyRates(startDate, endDate));
    }

}
