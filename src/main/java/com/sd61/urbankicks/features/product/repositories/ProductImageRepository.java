package com.sd61.urbankicks.features.product.repositories;

import com.sd61.urbankicks.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductImageRepository extends JpaRepository<ProductImage, UUID> {
//    long countByProductVariant(ProductVariant variant);
//
//    List<ProductImage> findByProductVariant(ProductVariant variant);
//
//    long countByProductVariantId(UUID productVariantId);
//
//    boolean existsByProductVariantIdAndIsThumbnailTrue(UUID productVariantId);
//
//    ProductImage findByProductVariantIdAndIsThumbnailTrue(UUID productVariantId);
List<ProductImage> findAllByProductId(UUID productId);
}