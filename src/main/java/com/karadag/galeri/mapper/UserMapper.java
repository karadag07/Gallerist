package com.karadag.galeri.mapper;

import org.mapstruct.Mapper;

import com.karadag.galeri.dto.ResponseUser;
import com.karadag.galeri.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    ResponseUser toResponse(User user);
}
