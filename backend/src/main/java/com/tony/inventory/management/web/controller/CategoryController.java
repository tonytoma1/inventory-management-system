package com.tony.inventory.management.web.controller;

import com.tony.inventory.management.business.service.CategoryService;
import com.tony.inventory.management.data.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

/**
 * RPC that returns JSON objects of the category table
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * @return all categories in the category table
     */
    @GetMapping
    public List<Category> getAllCategories() {
        List<Category> cat = categoryService.getAllCategories();

        return cat;
    }

    @GetMapping(path = "{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") int categoryId) {
       List<Category> categories = categoryService.getAllCategories();

       for(Category category : categories) {
           if(category.getCategoryId() == categoryId) {
               return category;
           }
       }
       Category cat = null;
       return cat;
    }
}
