package com.karadag.galeri.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.karadag.galeri.dto.RequestCar;
import com.karadag.galeri.dto.ResponseCar;
import com.karadag.galeri.entity.Car;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    Car toEntity(RequestCar requestCar);

    ResponseCar toResponse(Car car);
}
