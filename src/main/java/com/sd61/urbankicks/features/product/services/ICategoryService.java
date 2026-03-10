package com.sd61.urbankicks.features.product.services;

import com.sd61.urbankicks.entity.Category;
import com.sd61.urbankicks.features.product.dtos.requests.CategoryRequest;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    List<Category> getAllCategories();
    Category createCategory(CategoryRequest categoryDTO);
    Category updateCategory(UUID id, CategoryRequest categoryDTO);
    Category deleteCategory(UUID uuid);
    Category getCategoryById(UUID uuid);
}
