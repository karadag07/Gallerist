package com.karadag.galeri.service.IService;

import com.karadag.galeri.dto.RequestGallerist;
import com.karadag.galeri.dto.ResponseGallerist;

public interface IGalleristService {
    ResponseGallerist saveGallerist(RequestGallerist request);

}
