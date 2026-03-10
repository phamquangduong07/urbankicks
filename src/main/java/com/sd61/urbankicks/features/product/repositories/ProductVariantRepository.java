package com.sd61.urbankicks.features.product.repositories;

import com.sd61.urbankicks.entity.Product;
import com.sd61.urbankicks.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, UUID> {
    boolean existsByProductIdAndSizeIdAndColorId(UUID productId, UUID sizeId, UUID colorId);

    ProductVariant findProductVariantByProduct(Product product);

    List<ProductVariant> findAllByProductId(UUID productId);
}