package com.karadag.galeri.controller.IController;

import com.karadag.galeri.dto.RequestAccount;
import com.karadag.galeri.dto.ResponseAccount;

public interface IAccountController {
    public ResponseAccount saveAccount(RequestAccount account);
}
