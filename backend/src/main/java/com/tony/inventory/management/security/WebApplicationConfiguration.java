package com.tony.inventory.management.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The security configuration class for the entire java application. This class
 * defines the password encoder used, database used, and JWT (json web token) for the application.
 *
 * @author Tony Toma
 */
@Configuration
@EnableWebSecurity
public class WebApplicationConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().anyRequest().permitAll();
    }
}
