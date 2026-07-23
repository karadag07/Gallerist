package com.karadag.galeri.controller.IController;

import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestCar;
import com.karadag.galeri.dto.ResponseCar;

public interface ICarController {
    public OkResponse<ResponseCar> saveCar(RequestCar car);
}
