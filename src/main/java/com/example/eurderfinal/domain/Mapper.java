package com.example.eurderfinal.domain;

import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public  CreateCustomerDto toDto(Customer customer) {
        return new CreateCustomerDto(customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getPhoneNumber());
    }

    public  Customer toOriginal(CreateCustomerDto createCustomerDto) {
        return new Customer(createCustomerDto.firstName(),
                createCustomerDto.lastName(),
                createCustomerDto.email(),
                createCustomerDto.address(),
                createCustomerDto.phoneNumber());
    }

    public  CreateAddressDto toDto(Address address) {
        return new CreateAddressDto(address.getStreetName(),
                address.getStreetNumber(),
                address.getPostalCode(),
                address.getCityName(),
                address.getCountry());
    }

    public  Address toOriginal(CreateAddressDto createAddressDto) {
        return new Address(createAddressDto.streetName(),
                createAddressDto.streetNumber(),
                createAddressDto.postalCode(),
                createAddressDto.cityName(),
                createAddressDto.country());
    }
}


