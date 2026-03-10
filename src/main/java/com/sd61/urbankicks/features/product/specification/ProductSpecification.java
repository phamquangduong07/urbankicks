package com.sd61.urbankicks.features.product.specification;

import com.sd61.urbankicks.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class ProductSpecification {
    public static Specification<Product> hasCategory(UUID categoryId) {
        return (root, query, cb) ->
                categoryId == null ? null :
                        cb.equal(root.get("category").get("id"),categoryId );
    }
    public static Specification<Product> hasBrand(UUID brandId) {
        return (root, query, cb) ->
                brandId == null ? null :
                        cb.equal(root.get("brandId").get("id"), brandId);
    }

    public static Specification<Product> hasStatus(Integer status) {
        return (root, query, cb) ->
                status == null ? null :
                        cb.equal(root.get("status"), status);
    }

    public static Specification<Product> containsKeyword(String keyword) {
        return (root, query, cb) -> {
            if (keyword == null || keyword.trim().isEmpty()) return null;

            String likePattern = "%" + keyword.toLowerCase() + "%";

            return cb.or(
                    cb.like(cb.lower(root.get("name")), likePattern),
                    cb.like(cb.lower(root.get("code")), likePattern)

            );
        };
    }
}
