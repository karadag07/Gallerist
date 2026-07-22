package com.karadag.galeri.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karadag.galeri.entity.RefreshToken;
import com.karadag.galeri.entity.User;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByRefreshToken(String RefreshToken);

    Optional<RefreshToken> findByUser(User user);
}
