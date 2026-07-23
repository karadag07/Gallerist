package com.karadag.galeri.controller.IController;

import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestSaledCar;
import com.karadag.galeri.dto.ResponseSaledCar;

public interface ISaledCarController {
    public OkResponse<ResponseSaledCar> saveSaledCar(RequestSaledCar saledCar);
}
