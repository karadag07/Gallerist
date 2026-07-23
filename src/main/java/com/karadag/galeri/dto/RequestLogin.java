package com.karadag.galeri.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RequestLogin {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
