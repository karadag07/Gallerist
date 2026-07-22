package com.karadag.galeri.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.karadag.galeri.dto.ResponseGalleristCar;
import com.karadag.galeri.entity.Car;
import com.karadag.galeri.entity.Gallerist;
import com.karadag.galeri.entity.GalleristCar;

@Mapper(componentModel = "spring")
public interface GalleristCarMapper {

    ResponseGalleristCar toResponse(GalleristCar entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @org.mapstruct.Mapping(target = "gallerist", source = "galleristObject") // buradaki gallerist GalleristCaar
                                                                             // sınıfının ıcınde bulunan "gallerist1
                                                                             // alanıdır"
    @org.mapstruct.Mapping(target = "car", source = "carObject")
    GalleristCar toEntity(Gallerist galleristObject, Car carObject);
}