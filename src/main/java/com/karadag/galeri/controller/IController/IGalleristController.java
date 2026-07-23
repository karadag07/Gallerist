package com.karadag.galeri.controller.IController;

import com.karadag.galeri.dto.OkResponse;
import com.karadag.galeri.dto.RequestGallerist;
import com.karadag.galeri.dto.ResponseGallerist;

public interface IGalleristController {
    public OkResponse<ResponseGallerist> saveGallerist(RequestGallerist gallerist);
}
