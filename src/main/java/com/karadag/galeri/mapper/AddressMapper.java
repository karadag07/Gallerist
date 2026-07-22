package com.karadag.galeri.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.karadag.galeri.dto.RequestAddress;
import com.karadag.galeri.dto.ResponseAddress;
import com.karadag.galeri.entity.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    Address toEntity(RequestAddress requestAddress);

    ResponseAddress toResponse(Address address);
}
