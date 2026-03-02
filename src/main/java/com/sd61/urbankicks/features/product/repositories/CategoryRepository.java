package com.sd61.urbankicks.features.product.repositories;

import com.sd61.urbankicks.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {




    boolean existsCategoryByNameIgnoreCase(String name);


    boolean existsCategoryByNameIgnoreCaseAndIdNot(String name, UUID id);
}