package com.karadag.galeri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karadag.galeri.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
