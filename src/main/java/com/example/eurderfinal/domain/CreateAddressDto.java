package com.example.eurderfinal.domain;

public record CreateAddressDto(String streetName,
                               String streetNumber,
                               String postalCode,
                               String cityName,
                               String country) {
}
