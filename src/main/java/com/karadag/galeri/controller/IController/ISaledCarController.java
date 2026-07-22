package com.karadag.galeri.controller.IController;

import com.karadag.galeri.dto.RequestSaledCar;
import com.karadag.galeri.dto.ResponseSaledCar;

public interface ISaledCarController {
    public ResponseSaledCar saveSaledCar(RequestSaledCar saledCar);
}
