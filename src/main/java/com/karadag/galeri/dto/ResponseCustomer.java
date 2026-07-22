package com.karadag.galeri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCustomer {

    private String firstName;

    private String lastName;

    private ResponseAddress address;

    private ResponseAccount account;
}
