package com.example.eurderfinal.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "fk_pet_id")
    private Address address;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, Address address, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
