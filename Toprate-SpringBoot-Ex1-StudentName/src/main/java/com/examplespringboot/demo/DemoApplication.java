package com.examplespringboot.demo;

import com.examplespringboot.demo.Service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import javax.activation.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;

// Disable some Spring Boot auto config
@SpringBootApplication

// Disable some Spring Boot auto config
//@EnableAutoConfiguration(exclude = {
//    DataSourceAutoConfiguration.class,
//    DataSourceTransactionManagerAutoConfiguration.class,
//    HibernateJpaAutoConfiguration.class })

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner setDefaultData(CustomerService customerService) {
        return args -> {
            customerService.setDefaultData();
        };
    }

}

