package com.sd61.urbankicks.features.product.repositories;

import com.sd61.urbankicks.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID>, JpaSpecificationExecutor<Product> {
    boolean existsByNameIgnoreCase(String name);

    boolean existsByCodeIgnoreCase(String code);

    Optional<Product> findByCode(String code);

    boolean existsByNameIgnoreCaseAndIdNot(String name, UUID id);

    boolean existsByCodeIgnoreCaseAndIdNot(String code, UUID id);
    boolean existsById(UUID id);
}