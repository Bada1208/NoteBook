package com.sysoiev.notebook.config;

import javax.sql.DataSource;

import com.sysoiev.notebook.dao.SpringContactDao;
import com.sysoiev.notebook.dao.impl.SpringContactDaoImpl;
import com.sysoiev.notebook.services.ContactService;
import com.sysoiev.notebook.services.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Next step is to create spring configuration class to define DataSource bean. I am using java
 * based configuration, you can also do this using spring bean configuration xml file.
 *
 * @Configuration – says that this class is configuration for Spring context.
 * @ComponentScan("com.sysoiev.notebook")- specifies the package to scan for component classes.
 * @PropertySource(“classpath:database.properties”)- says that properties will be read from database.properties file.
 */

@Configuration
@ComponentScan("com.sysoiev.notebook")
@PropertySource("classpath:database.properties")
public class AppSpringJdbcConfig {

    @Autowired
    Environment environment;

    private final String DB_URL = "url";
    private final String USER = "user";
    private final String DRIVER = "driver";
    private final String PASSWORD = "password";

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty(DB_URL));
        driverManagerDataSource.setUsername(environment.getProperty(USER));
        driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
        driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
        return driverManagerDataSource;
    }
    //from CmdLineServiceImpl class
    @Bean
    public BufferedReader br() throws NullPointerException{
        return new BufferedReader(new InputStreamReader(System.in));
    }
    //from CmdLineServiceImpl class
    @Bean
    public SpringContactDao springContactDao(DataSource dataSource) throws NullPointerException{
        return new SpringContactDaoImpl(dataSource);
    }
}
