package com.tony.inventory.management.data.entity;

import javax.persistence.*;

/**
 * Represents the category table in the database.
 */
@Entity
@Table(name="category")
public class Category {

    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int categoryId;

    @Column(name="category_name")
    public String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
