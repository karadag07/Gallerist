package com.karadag.galeri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karadag.galeri.entity.SaledCar;

public interface SaledCarRepository extends JpaRepository<SaledCar, Long> {

}
