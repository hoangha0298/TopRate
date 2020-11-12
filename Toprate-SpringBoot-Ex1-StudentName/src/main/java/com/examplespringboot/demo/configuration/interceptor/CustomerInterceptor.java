package com.examplespringboot.demo.configuration.interceptor;

import com.examplespringboot.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CustomerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("aaaa");
        System.out.println(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
    }

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
//
//        if (localeResolver == null) {
//            throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
//        }
//
//        // Lấy ra thông tin Locale từ LocaleResolver
//        Locale locale = localeResolver.resolveLocale(request);
//
//        localeResolver.setLocale(request, response, locale);
//
//        return true;
//    }

}
