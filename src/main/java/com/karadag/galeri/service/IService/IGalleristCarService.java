package com.karadag.galeri.service.IService;

import com.karadag.galeri.dto.RequestGalleristCar;
import com.karadag.galeri.dto.ResponseGalleristCar;

public interface IGalleristCarService {

    ResponseGalleristCar saveGalleristCar(RequestGalleristCar request);
}
