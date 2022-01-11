package com.example.eurderfinal.domain;

public record CreateCustomerDto(String firstName,
                                String lastName,
                                String email,
                                Address address,
                                String phoneNumber) {
}