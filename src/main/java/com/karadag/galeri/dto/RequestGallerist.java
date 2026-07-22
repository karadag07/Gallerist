package com.karadag.galeri.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestGallerist {
    private String firstName;

    private String lastName;

    @NotNull
    @Valid
    private RequestAddress address;
}
