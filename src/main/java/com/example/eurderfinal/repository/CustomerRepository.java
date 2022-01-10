package com.example.eurderfinal.repository;

import com.example.eurderfinal.domain.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("select c from Customer c", Customer.class)
                .getResultList();
    }

//    private final List<Customer> customerList;
//
//    public CustomerRepository() {
//        this.customerList = new ArrayList<>();
//    }
//
//    public void add(Customer customer) {
//        customerList.add(customer);
//    }
//
//    public List<Customer> getCustomerList() {
//        return customerList;
//    }
}
