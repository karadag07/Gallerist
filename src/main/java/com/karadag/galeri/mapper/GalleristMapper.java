package com.karadag.galeri.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.karadag.galeri.dto.RequestGallerist;
import com.karadag.galeri.dto.ResponseGallerist;
import com.karadag.galeri.entity.Gallerist;

@Mapper(componentModel = "spring", uses = { AddressMapper.class })
public interface GalleristMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    Gallerist toEntity(RequestGallerist requestGallerist);

    ResponseGallerist toResponse(Gallerist gallerist);
}
