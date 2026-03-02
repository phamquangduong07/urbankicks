package com.sd61.urbankicks.features.product.repositories;

import com.sd61.urbankicks.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ColorRepository extends JpaRepository<Color, UUID> {
    boolean existsByNameIgnoreCase(String name);

    boolean existsByHexCodeIgnoreCase(String hexCode);

    boolean existsByNameIgnoreCaseAndIdNot(String name, UUID id);

    boolean existsByHexCodeIgnoreCaseAndIdNot(String hexCode, UUID id);
}