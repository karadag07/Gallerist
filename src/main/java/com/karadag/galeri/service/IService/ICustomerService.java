package com.karadag.galeri.service.IService;

import com.karadag.galeri.dto.RequestCustomer;
import com.karadag.galeri.dto.ResponseCustomer;

public interface ICustomerService {

    ResponseCustomer saveCustomer(RequestCustomer request);
}
