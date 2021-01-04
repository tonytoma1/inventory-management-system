package com.tony.inventory.management.data.repository;

import com.tony.inventory.management.data.entity.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends CrudRepository<User, Integer> {
}
