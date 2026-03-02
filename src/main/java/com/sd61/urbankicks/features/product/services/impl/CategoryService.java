package com.sd61.urbankicks.features.product.services.impl;

import com.sd61.urbankicks.entity.Category;
import com.sd61.urbankicks.exceptions.DataNotFoundException;
import com.sd61.urbankicks.exceptions.DuplicateResourceException;
import com.sd61.urbankicks.features.product.dtos.CategoryDTO;
import com.sd61.urbankicks.features.product.repositories.CategoryRepository;
import com.sd61.urbankicks.features.product.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        if(categoryRepository.existsCategoryByNameIgnoreCase(categoryDTO.getName())){
            throw new DuplicateResourceException("Tên danh mục đã tồn tại");
        }
        Category newCategory = Category.builder()
                .name(categoryDTO.getName())
                .status(categoryDTO.getStatus())
                .build();
        return categoryRepository.save(newCategory);
    }

    @Override
    public Category updateCategory(UUID id, CategoryDTO categoryDTO) {
        Category existingCategory = getCategoryById(id);

        existingCategory.setName(categoryDTO.getName());
        existingCategory.setStatus(categoryDTO.getStatus());
        if(categoryRepository.existsCategoryByNameIgnoreCaseAndIdNot(categoryDTO.getName(),id)){
            throw new DuplicateResourceException("Tên danh mục đã tồn tại");
        }
        return categoryRepository.save(existingCategory);

    }

    @Override
    public Category deleteCategory(UUID uuid) {
        Category existingCategory = getCategoryById(uuid);
        existingCategory.setStatus(0);
        return categoryRepository.save(existingCategory);
    }

    @Override
    public Category getCategoryById(UUID uuid) {
        return categoryRepository.findById(uuid).orElseThrow(()-> new DataNotFoundException("Không tìm thấy danh mục"));
    }
}
