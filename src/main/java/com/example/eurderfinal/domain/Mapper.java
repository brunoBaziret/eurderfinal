package com.example.eurderfinal.domain;

import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Customer toOriginal(CreateCustomerDto createCustomerDto) {
        return new Customer(createCustomerDto.firstName(),
                createCustomerDto.lastName(),
                createCustomerDto.email(),
                createCustomerDto.address(),
                createCustomerDto.phoneNumber());
    }

    public ViewCustomerDto toViewDto(Customer customer) {
        return new ViewCustomerDto(customer.getId().toString(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getPhoneNumber());
    }
}


