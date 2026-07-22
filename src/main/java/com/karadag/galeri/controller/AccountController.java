package com.karadag.galeri.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karadag.galeri.controller.IController.IAccountController;
import com.karadag.galeri.dto.RequestAccount;
import com.karadag.galeri.dto.ResponseAccount;
import com.karadag.galeri.service.IService.IAccountService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AccountController implements IAccountController {
    private final IAccountService accountService;

    @PostMapping("/account")
    @Override
    public ResponseAccount saveAccount(@RequestBody @Valid RequestAccount account) {
        return accountService.saveAccount(account);
    }
}
