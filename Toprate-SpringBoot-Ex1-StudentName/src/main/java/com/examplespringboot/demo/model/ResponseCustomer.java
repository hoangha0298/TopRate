package com.examplespringboot.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResponseCustomer extends Customer{

    private String nameEN;

    public ResponseCustomer(Customer customer, String nameEN) {
        super(customer.getId(), customer.getName(), customer.getEmail(), customer.getAge());
        this.nameEN = nameEN;
    }

    @JsonIgnore
    @Override
    public String getName() {
        return "";
    }

    @Override
    public void setName(String name) {
    }

    public String getNameVN() {
        return super.getName();
    }

    public void setNameVN(String name) {
        super.setName(name);
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    @Override
    public String toString() {
        return "ResponseCustomer{" +
                "super=" + super.toString() +
                ", nameEN='" + nameEN + '\'' +
                '}';
    }
}
