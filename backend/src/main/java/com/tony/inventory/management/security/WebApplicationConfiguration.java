package com.tony.inventory.management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tony.inventory.management.business.service.ApplicationUserService;
import com.tony.inventory.management.business.service.UserService;

/**
 * The security configuration class for the entire java application. This class
 * defines the password encoder used, database used, and JWT (json web token) for the application.
 *
 * @author Tony Toma
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebApplicationConfiguration extends WebSecurityConfigurerAdapter {

	private PasswordEncoder passwordEncoder;
	private UserService userService;
	private ApplicationUserService applicationUserService;
	
    public WebApplicationConfiguration(PasswordEncoder passwordEncoder, UserService userService,
    		ApplicationUserService applicationUserService) {
		this.passwordEncoder = passwordEncoder;
		this.userService = userService;
		this.applicationUserService = applicationUserService;
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().anyRequest().permitAll();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	/**
	 * Sets up the password encoder and the database authentication
	 */
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(applicationUserService);
		return provider;
	}
    
    
}
