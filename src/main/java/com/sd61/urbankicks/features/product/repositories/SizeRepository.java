package com.sd61.urbankicks.features.product.repositories;

import com.sd61.urbankicks.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface SizeRepository extends JpaRepository<Size, UUID> {
    boolean existsSizeBySizeValue(BigDecimal sizeValue);

    boolean existsBySizeValueAndIdNot(BigDecimal sizeValue, UUID id);
}