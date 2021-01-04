package com.tony.inventory.management.web.controller;

import com.tony.inventory.management.business.service.CategoryService;
import com.tony.inventory.management.data.entity.Category;
import com.tony.inventory.management.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public void saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }
}
