package com.karadag.galeri.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.karadag.galeri.dto.ResponseSaledCar;
import com.karadag.galeri.entity.Car;
import com.karadag.galeri.entity.Customer;
import com.karadag.galeri.entity.Gallerist;
import com.karadag.galeri.entity.SaledCar;

@Mapper(componentModel = "spring")
public interface SaledCarMapper {
    ResponseSaledCar toResponse(SaledCar saledCar);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @org.mapstruct.Mapping(target = "car", source = "carObject")
    @org.mapstruct.Mapping(target = "customer", source = "customerObject")
    @org.mapstruct.Mapping(target = "gallerist", source = "galleristObject")
    SaledCar toEntity(Car carObject, Customer customerObject, Gallerist galleristObject);

}
