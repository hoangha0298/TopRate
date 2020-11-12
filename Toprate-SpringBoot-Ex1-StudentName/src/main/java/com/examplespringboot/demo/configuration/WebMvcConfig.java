package com.examplespringboot.demo.configuration;

import com.examplespringboot.demo.configuration.interceptor.CustomerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    CustomerInterceptor customerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(customerInterceptor).addPathPatterns("/customer/*");
    }

}
