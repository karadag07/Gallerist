package com.karadag.galeri.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestSaledCar {

    @NotNull
    private Long galleristId;

    @NotNull
    private Long carId;

    @NotNull
    private Long customerId;
}
