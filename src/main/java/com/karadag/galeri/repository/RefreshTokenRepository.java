package com.karadag.galeri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karadag.galeri.entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

}
