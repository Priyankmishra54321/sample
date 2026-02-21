//package com.db;
//import com.db.trace.TraceIdFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//
//    @Bean
//    public FilterRegistrationBean<TraceIdFilter> traceIdFilter() {
//        FilterRegistrationBean<TraceIdFilter> registration = new FilterRegistrationBean<>();
//        registration.setFilter(new TraceIdFilter());
//        registration.setOrder(1);
//        registration.addUrlPatterns("/*");
//        return registration;
//    }
//}
//
