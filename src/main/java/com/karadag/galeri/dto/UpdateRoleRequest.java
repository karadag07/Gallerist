package com.karadag.galeri.dto;

import com.karadag.galeri.enums.RoleType;

import lombok.Data;

@Data
public class UpdateRoleRequest {

    private RoleType role;

}