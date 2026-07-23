package com.karadag.galeri.controller.IController;

import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestCustomer;
import com.karadag.galeri.dto.ResponseCustomer;

public interface ICustomerController {
    public OkResponse<ResponseCustomer> saveCustomer(RequestCustomer customer);
}
