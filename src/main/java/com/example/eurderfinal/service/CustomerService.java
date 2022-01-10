package com.example.eurderfinal.service;

import com.example.eurderfinal.domain.Customer;
import com.example.eurderfinal.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public Customer getCustomer(String id) {
        for (Customer customer : customerRepository.getAllCustomers()) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        throw new NoSuchElementException("Customer not found");
    }
}
