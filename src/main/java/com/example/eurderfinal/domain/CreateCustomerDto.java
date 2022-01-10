package com.example.eurderfinal.domain;

public record CreateCustomerDto(String id,
                                String firstName,
                                String lastName,
                                String email,
                                Address address,
                                String phoneNumber) {
}