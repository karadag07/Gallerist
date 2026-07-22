package com.karadag.galeri.service.IService;

import com.karadag.galeri.dto.RequestCar;
import com.karadag.galeri.dto.ResponseCar;

public interface ICarService {
    ResponseCar saveCar(RequestCar request);
}
