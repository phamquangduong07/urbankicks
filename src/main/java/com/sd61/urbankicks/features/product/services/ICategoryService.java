package com.sd61.urbankicks.features.product.services;

import com.sd61.urbankicks.entity.Category;
import com.sd61.urbankicks.features.product.dtos.CategoryDTO;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    List<Category> getAllCategories();
    Category createCategory(CategoryDTO categoryDTO);
    Category updateCategory(UUID id, CategoryDTO categoryDTO);
    Category deleteCategory(UUID uuid);
    Category getCategoryById(UUID uuid);
}
