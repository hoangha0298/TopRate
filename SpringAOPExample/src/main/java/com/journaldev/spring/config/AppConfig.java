package com.journaldev.spring.config;

import com.journaldev.spring.model.Employee;
import com.journaldev.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.journaldev.spring.aspect")
public class AppConfig {

    @Bean(name = "hoangha")
    public Employee getEmployee () {
        System.out.println("create employee");
        Employee e = new Employee();
        e.setName("hoang");
        return e;
    }

    @Bean
    public EmployeeService getEmployeeService (@Qualifier("hoangha") Employee employee) {
        System.out.println("create employee service");
        EmployeeService employeeService = new EmployeeService();
        employeeService.setEmployee(employee);
        return employeeService;
    }

}
