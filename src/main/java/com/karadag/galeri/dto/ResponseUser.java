package com.karadag.galeri.dto;

import com.karadag.galeri.enums.RoleType;

import lombok.Data;

@Data
public class ResponseUser {
    private String username;
    private String email;
    private RoleType role;

}
