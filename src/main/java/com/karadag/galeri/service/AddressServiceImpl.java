package com.karadag.galeri.service;

import org.springframework.stereotype.Service;

import com.karadag.galeri.dto.RequestAddress;
import com.karadag.galeri.dto.ResponseAddress;
import com.karadag.galeri.entity.Address;
import com.karadag.galeri.mapper.AddressMapper;
import com.karadag.galeri.repository.AddressRepository;
import com.karadag.galeri.service.IService.IAddressService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements IAddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public ResponseAddress saveAddress(RequestAddress request) {
        Address address = addressMapper.toEntity(request);
        Address savedAddress = addressRepository.save(address);

        return addressMapper.toResponse(savedAddress);

    }

}
