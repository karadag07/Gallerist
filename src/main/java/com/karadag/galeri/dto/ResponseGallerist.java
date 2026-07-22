package com.karadag.galeri.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({ "firstName", "lastName", "address" })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGallerist {
    private String firstName;

    private String lastName;

    private ResponseAddress address;
}
