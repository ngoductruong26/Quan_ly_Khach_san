package com.hotel.mapper;

import com.hotel.dto.CustomerDTO;
import com.hotel.entity.Customer;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
        if (customer == null) return null;

        CustomerDTO dto = new CustomerDTO();

        dto.setId(customer.getId());
        dto.setFullName(customer.getFullName());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setAddress(customer.getAddress());
        dto.setIdentityNumber(customer.getIdentityNumber());

        return dto;
    }

    public static Customer toEntity(CustomerDTO dto) {
        if (dto == null) return null;

        Customer customer = new Customer();

        customer.setId(dto.getId());
        customer.setFullName(dto.getFullName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customer.setIdentityNumber(dto.getIdentityNumber());

        return customer;
    }
}