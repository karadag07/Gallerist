package com.karadag.galeri.dto;

import java.util.Date;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCustomer {

    private String firstName;

    private String lastName;

    private String tckn;

    private Date birthOfDate;

    @NotNull
    @Valid
    private RequestAddress address;

    @NotNull
    @Valid
    private RequestAccount account;
}
