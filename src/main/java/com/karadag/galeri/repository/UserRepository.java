package com.karadag.galeri.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karadag.galeri.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
