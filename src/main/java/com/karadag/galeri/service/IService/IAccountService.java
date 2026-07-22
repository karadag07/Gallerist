package com.karadag.galeri.service.IService;

import com.karadag.galeri.dto.RequestAccount;
import com.karadag.galeri.dto.ResponseAccount;

public interface IAccountService {

    ResponseAccount saveAccount(RequestAccount request);
}
