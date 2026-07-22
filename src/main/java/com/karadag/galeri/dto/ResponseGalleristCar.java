package com.karadag.galeri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGalleristCar {
    private ResponseGallerist gallerist;

    private ResponseCar car;
}
