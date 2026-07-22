package com.karadag.galeri.service;

import org.springframework.stereotype.Service;

import com.karadag.galeri.dto.RequestCustomer;
import com.karadag.galeri.dto.ResponseCustomer;
import com.karadag.galeri.entity.Customer;
import com.karadag.galeri.mapper.CustomerMapper;
import com.karadag.galeri.repository.CustomerRepository;
import com.karadag.galeri.service.IService.ICustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public ResponseCustomer saveCustomer(RequestCustomer request) {// Customer icinde Address ve Account nesneleri var

        Customer customer = customerMapper.toEntity(request);

        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(savedCustomer);
    }

}
