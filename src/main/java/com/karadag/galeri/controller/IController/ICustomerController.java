package com.karadag.galeri.controller.IController;

import com.karadag.galeri.dto.RequestCustomer;
import com.karadag.galeri.dto.ResponseCustomer;

public interface ICustomerController {
    public ResponseCustomer saveCustomer(RequestCustomer customer);
}
