package com.example.eurderfinal.repository;

import com.example.eurderfinal.domain.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

//    --BEGIN
//    This code uses persistence

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addCustomer(Customer customer) {
        System.out.println("I WAS HERE!!");
        entityManager.persist(customer);
    }

    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("select c from Customer c", Customer.class)
                .getResultList();
    }
//    --END


//    private final List<Customer> customerList;
//
//    public CustomerRepository() {
//        this.customerList = new ArrayList<>();
//    }
//
//    public void addCustomer(Customer customer) {
//        customerList.add(customer);
//    }
//
//    public List<Customer> getAllCustomers() {
//        return customerList;
//    }
}
