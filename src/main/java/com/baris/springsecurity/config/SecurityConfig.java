package com.baris.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //add the security data source
    @Autowired
    private DataSource securityDataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       //use jdbc auth

        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasAnyRole("MANAGER")
                .antMatchers("/systems/**").hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/loginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }
}
