package com.tony.inventory.management.business.service;

import com.tony.inventory.management.data.entity.User;
import com.tony.inventory.management.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
     * Inserts a user into the database
     */
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
