package com.karadag.galeri.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.karadag.galeri.dto.RequestAccount;
import com.karadag.galeri.dto.ResponseAccount;
import com.karadag.galeri.entity.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    Account toEntity(RequestAccount requestAccount);

    ResponseAccount toResponse(Account account);
}
