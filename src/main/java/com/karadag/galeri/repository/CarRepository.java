package com.karadag.galeri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karadag.galeri.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
