package com.tony.inventory.management.data.repository;

import com.tony.inventory.management.data.entity.Category;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
@EnableJpaRepositories
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
