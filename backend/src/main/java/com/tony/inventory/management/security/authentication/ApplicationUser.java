package com.tony.inventory.management.security.authentication;

import com.tony.inventory.management.data.entity.Role;
import com.tony.inventory.management.data.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.tony.inventory.management.business.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import javax.naming.directory.SearchControls;

/**
 * Creates the ability to login and authenticate a user from the database.
 */
public class ApplicationUser implements UserDetails {

    private User user;
    
    public ApplicationUser(User user) {
    	this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	Role role = user.getRole();
    	
    	ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
    	list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
    	
        return list;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
    	if(user.getIsAccountNonExpired() == 0) {
    		return false;
    	}
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
    	if(user.getIsAccountNonLocked() == 0) {
    		return false;
    	}
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if(user.getIsCredentialsNonExpired() == 0) {
        	return false;
        }
    	
    	return true;
    }

    @Override
    public boolean isEnabled() {
    	if(user.getIsEnabled() == 0) {
    		return false;
    	}
        return true;
    }


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
    
}
