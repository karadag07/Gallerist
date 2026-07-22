package com.karadag.galeri.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karadag.galeri.controller.IController.ICustomerController;
import com.karadag.galeri.dto.RequestCustomer;
import com.karadag.galeri.dto.ResponseCustomer;
import com.karadag.galeri.service.IService.ICustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController implements ICustomerController {

    private final ICustomerService customerService;

    @PostMapping("/customer")
    @Override
    public ResponseCustomer saveCustomer(@RequestBody @Valid RequestCustomer customer) {
        return customerService.saveCustomer(customer);
    }
}
