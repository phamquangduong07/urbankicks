package com.sd61.urbankicks.features.product.repositories;

import com.sd61.urbankicks.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {

    boolean existsBrandByNameIgnoreCaseAndIdNot(String name, UUID id);

    boolean existsBrandByNameIgnoreCase(String name);
}