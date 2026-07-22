package com.karadag.galeri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestAddress {

    private String city;

    private String district;

    private String neighborhood;

    private String street;
}
