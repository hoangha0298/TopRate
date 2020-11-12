package com.examplespringboot.demo.repository;

import com.examplespringboot.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCustomer extends CrudRepository<Customer, Integer> {
}
