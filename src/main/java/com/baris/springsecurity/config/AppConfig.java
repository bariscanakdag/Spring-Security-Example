package com.baris.springsecurity.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.baris.springsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {

    @Autowired
    private Environment env;

    private Logger logger = Logger.getLogger(getClass().getName());

    //define a bean ViewResolver

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/"); //Url görüntüleme ön eki.
        viewResolver.setSuffix(".jsp"); //Url görüntülüme son eki.

        return viewResolver;


    }

    @Bean
    public DataSource securityDataSource() {

        //Create connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        //set jdbc  driver class
        try {

            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));

        } catch (PropertyVetoException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        //Log the connection props

        logger.info("jdbc url : " + env.getProperty("jdbc.url"));
        logger.info("jdbc user : " + env.getProperty("jdbc.user"));
        logger.info("jdbc pass " + env.getProperty("jdbc.password"));


        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));


        securityDataSource.setInitialPoolSize(convertStringToInteger("connection.pool.initialPoolSize"));
        securityDataSource.setMaxPoolSize(convertStringToInteger("connection.pool.maxPoolSize"));
        securityDataSource.setMinPoolSize(convertStringToInteger("connection.pool.minPoolSize"));
        securityDataSource.setMaxIdleTime(convertStringToInteger("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    private Integer convertStringToInteger(String propValue) {

        String envProperty = env.getProperty(propValue);

        return Integer.parseInt(envProperty);
    }
}
