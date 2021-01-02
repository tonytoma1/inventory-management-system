package com.tony.inventory.management.business.service;

import com.tony.inventory.management.data.entity.Category;
import com.tony.inventory.management.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Retrieves categories from the category table.
 */
@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        Iterable<Category> categoryIterator = categoryRepository.findAll();
        List<Category> categories = new ArrayList<Category>();

        categoryIterator.forEach(x -> categories.add(x));

        return categories;

    }

}
