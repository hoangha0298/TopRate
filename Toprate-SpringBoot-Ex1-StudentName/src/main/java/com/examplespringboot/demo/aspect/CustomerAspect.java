package com.examplespringboot.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// cắt vào service
@Component
@Aspect
public class CustomerAspect {

    @Before("execution(* com.examplespringboot.demo.service.CustomerService.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint){
        System.out.println();
        System.out.println("=========================== ASPECT ===========================");
        System.out.println("Before method = " + joinPoint.getSignature().getName());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println();
    }

    // sửa input của hàm getCustomerById tăng id lên 1
    @Around("execution(* com.examplespringboot.demo.service.CustomerService.getCustomerById(..))")
    public Object changeArgsMethod(ProceedingJoinPoint proceedingJoinPoin) throws Throwable{

        //get original args
        Object[] args = proceedingJoinPoin.getArgs();

        // log
        System.out.println();
        System.out.println("=========================== ASPECT ===========================");
        System.out.println("Change args method = " + proceedingJoinPoin.getSignature().getName());
        System.out.println("Args before = " + Arrays.toString(args));

        // change value
        int value = (int) args[0] + 1;
        args[0] = value;

        System.out.println();
        return proceedingJoinPoin.proceed(args);
    }

    @AfterReturning(pointcut="execution(* com.examplespringboot.demo.service.CustomerService.*(..))", returning="result")
	public void logAfterReturnMethod(JoinPoint joinPoint, Object result){
        System.out.println();
        System.out.println("=========================== ASPECT ===========================");
        System.out.println("After return method = " + joinPoint.getSignature().getName());
        if (result != null) System.out.println("Type return = " + result.getClass().getSimpleName());
		System.out.println("result = " + result);
        System.out.println();
	}

}
