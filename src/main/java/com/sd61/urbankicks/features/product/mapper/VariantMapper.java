package com.sd61.urbankicks.features.product.mapper;

import com.sd61.urbankicks.entity.Color;
import com.sd61.urbankicks.entity.Product;
import com.sd61.urbankicks.entity.ProductVariant;
import com.sd61.urbankicks.entity.Size;
import com.sd61.urbankicks.features.product.dtos.requests.creates.CreateVariantRequest;
import org.springframework.stereotype.Component;

@Component
public class VariantMapper {
    public static ProductVariant toEntity(Product product, CreateVariantRequest request
    ,Size size, Color color) {
        ProductVariant variant = new ProductVariant();
        variant.setProduct(product);
        variant.setSize(size);
        variant.setColor(color);
        variant.setPrice(request.getPrice());
        variant.setStock(request.getStock());
        variant.setStatus(request.getStatus());
        variant.setCost(request.getCost());
        return variant;
    }
}
