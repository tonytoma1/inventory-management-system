package com.tony.inventory.management.business.service;

import com.tony.inventory.management.data.entity.User;
import com.tony.inventory.management.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all of the rows in the user table
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(x -> users.add(x));

        return users;
    }
    
    /**
     * Finds the user based on the username. If the user isn't found, 
     * a UsernameNotFoundException is thrown.
     * @param username the username to look for 
     * @return the User if found. If not found, then an exception is thrown.
     * @throws UsernameNotFoundException if the user is not found.
     */
    public User getUserByUsername(String username) throws UsernameNotFoundException {
    	List<User> users = new ArrayList<>();
    	
        userRepository.findAll().forEach(x -> users.add(x));
        
        User userFound = null;
        
        for(int i = 0; i < users.size(); i++) {
        	if(users.get(i).getUsername().equals(username)) {
        		userFound = users.get(i);
        		return userFound;
        	}
        }
        
       if(userFound == null) {
    	   throw new UsernameNotFoundException("user not found");
       }
        
       return userFound;
        
        
        
    }

    /**
     * Inserts a user into the database
     */
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
