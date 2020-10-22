package com.examplespringboot.demo.Controller;

import com.examplespringboot.demo.Model.Customer;
import com.examplespringboot.demo.Model.ResponseDelete;
import com.examplespringboot.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;     // singleton service khách hàng

    @PostMapping("customers/create")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomers(customer);
    }

    @GetMapping("customers/list")
    public ArrayList<Customer> getAllCustomer() {
        return customerService.getAllCustomers();
    }

    @GetMapping("customer/{cusId}")
    public Customer getCustomerById(@PathVariable int cusId) {
        return customerService.getCustomerById(cusId);
    }

    @GetMapping("customer/delete/{cusId}")
    public ResponseDelete deleteCustomerById(@PathVariable int cusId) {
        ResponseDelete responseDelete = new ResponseDelete();
        responseDelete.setSucess(customerService.deleteCustomerById(cusId));
        return responseDelete;
    }

}
