package com.karadag.galeri.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.karadag.galeri.dto.RequestCustomer;
import com.karadag.galeri.dto.ResponseCustomer;
import com.karadag.galeri.entity.Customer;

@Mapper(componentModel = "spring", uses = { AccountMapper.class, AddressMapper.class })
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    Customer toEntity(RequestCustomer requestCustomer);

    ResponseCustomer toResponse(Customer customer);
}