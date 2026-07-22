package com.karadag.galeri.controller.IController;

import com.karadag.galeri.dto.RequestGalleristCar;
import com.karadag.galeri.dto.ResponseGalleristCar;

public interface IGalleristCarControllar {
    public ResponseGalleristCar saveGalleristCar(RequestGalleristCar galleristCar);
}
