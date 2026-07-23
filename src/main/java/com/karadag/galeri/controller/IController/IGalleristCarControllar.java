package com.karadag.galeri.controller.IController;

import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestGalleristCar;
import com.karadag.galeri.dto.ResponseGalleristCar;

public interface IGalleristCarControllar {
    public OkResponse<ResponseGalleristCar> saveGalleristCar(RequestGalleristCar galleristCar);
}
