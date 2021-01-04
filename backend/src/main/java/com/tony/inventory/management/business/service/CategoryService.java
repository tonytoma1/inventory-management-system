package com.tony.inventory.management.business.service;

import com.tony.inventory.management.data.entity.Category;
import com.tony.inventory.management.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Returns all of the categories in the database
     */
    public List<Category> getAllCategories() {
        List<Category> cat = new ArrayList<>();
        categoryRepository.findAll().forEach(x -> cat.add(x));

        return cat;
    }

    /**
     * Saves the category into the database
     */
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}
