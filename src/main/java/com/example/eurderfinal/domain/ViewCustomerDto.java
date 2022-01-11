package com.example.eurderfinal.domain;

public record ViewCustomerDto(String id,
                              String firstName,
                              String lastName,
                              String email,
                              Address address,
                              String phoneNumber) {
}
