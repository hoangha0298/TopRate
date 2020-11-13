package com.journaldev.spring.main;

import com.journaldev.spring.aspect.EmployeeAfterAspect;
import com.journaldev.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.spring.service.EmployeeService;
import org.springframework.stereotype.Component;

public class SpringMain {

	public static void main(String[] args) {

//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//		System.out.println("=================");
//		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);
//
//		System.out.println(employeeService.getEmployee().getName());
//
//		employeeService.getEmployee().setName("Pankaj");
//
//		employeeService.getEmployee().throwException();
//
//		ctx.close();


		AnnotationConfigApplicationContext acac =
				new AnnotationConfigApplicationContext(new String[] {"com.journaldev.spring.config"});
		System.out.println("=================");
		EmployeeService employeeService = acac.getBean(EmployeeService.class);

		System.out.println(employeeService.getEmployee().getName());

		employeeService.getEmployee().setName("Pankaj");

		employeeService.getEmployee().throwException();

		acac.close();
	}

}
