package com.baris.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.baris.springsecurity")
public class AppConfig {

    //define a bean ViewResolver

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/"); //Url görüntüleme ön eki.
        viewResolver.setSuffix(".jsp"); //Url görüntülüme son eki.

        return  viewResolver;
    }
}
