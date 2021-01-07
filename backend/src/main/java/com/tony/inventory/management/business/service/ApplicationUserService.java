package com.tony.inventory.management.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tony.inventory.management.security.authentication.ApplicationUser;

/**
 * Finds the user from the database. 
 * @author Tony Toma
 *
 */
@Service
public class ApplicationUserService implements UserDetailsService {

	private UserService userService;
	
	
	@Autowired
	public ApplicationUserService(UserService userService) {
		this.userService = userService;
	}




	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new ApplicationUser(userService.getUserByUsername(username));
		
	}

}
