package com.karadag.galeri.controller.IController;

import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestAccount;
import com.karadag.galeri.dto.ResponseAccount;

public interface IAccountController {
    public OkResponse<ResponseAccount> saveAccount(RequestAccount account);
}
