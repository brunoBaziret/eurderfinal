package com.example.eurderfinal.api;

import com.example.eurderfinal.domain.CreateCustomerDto;
import com.example.eurderfinal.domain.Customer;
import com.example.eurderfinal.domain.Mapper;
import com.example.eurderfinal.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final Mapper mapper;
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerService customerService, Mapper mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomerAccount(@RequestBody CreateCustomerDto createCustomerDto) {
        logger.info("Method 'createCustomerAccount' started");
        Customer customer = mapper.toOriginal(createCustomerDto);
        customerService.saveCustomer(customer);
        logger.info("Method 'createCustomerAccount' finished");
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CreateCustomerDto> getAllCustomers() {
        logger.info("Method 'getAllCustomers' started");
        List<Customer> customerList = customerService.getAllCustomers();
        List<CreateCustomerDto> customerDtoList = customerList.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        logger.info("Method 'getAllCustomers' finished");
        return customerDtoList;
    }

    @GetMapping(path = "{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CreateCustomerDto getCustomer(@PathVariable("id") String id) {
        logger.info("Method 'getCustomer' started");
        Customer customer = customerService.getCustomer(id);
        CreateCustomerDto createCustomerDto= mapper.toDto(customer);
        logger.info("Method 'getCustomer' finished");
        return createCustomerDto;
    }
}
