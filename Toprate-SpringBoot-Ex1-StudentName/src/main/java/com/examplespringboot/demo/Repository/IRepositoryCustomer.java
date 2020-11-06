package com.examplespringboot.demo.Repository;

import com.examplespringboot.demo.Model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCustomer extends CrudRepository<Customer, Integer> {
}
