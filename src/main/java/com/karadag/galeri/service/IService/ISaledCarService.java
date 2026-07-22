package com.karadag.galeri.service.IService;

import com.karadag.galeri.dto.RequestSaledCar;
import com.karadag.galeri.dto.ResponseSaledCar;

public interface ISaledCarService {

    ResponseSaledCar saveSaledCar(RequestSaledCar request);
}
