package com.karadag.galeri.service;

import org.springframework.stereotype.Service;

import com.karadag.galeri.dto.RequestAccount;
import com.karadag.galeri.dto.ResponseAccount;
import com.karadag.galeri.entity.Account;
import com.karadag.galeri.mapper.AccountMapper;
import com.karadag.galeri.repository.AccountRepository;
import com.karadag.galeri.service.IService.IAccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public ResponseAccount saveAccount(RequestAccount request) {
        Account account = accountMapper.toEntity(request);
        Account savedAccount = accountRepository.save(account);

        return accountMapper.toResponse(savedAccount);
    }

}
