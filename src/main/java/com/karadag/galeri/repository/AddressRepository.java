package com.karadag.galeri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karadag.galeri.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
