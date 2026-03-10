package com.sd61.urbankicks.features.product.services;

import com.sd61.urbankicks.features.product.dtos.ProductFilterRequest;
import com.sd61.urbankicks.features.product.dtos.requests.creates.CreateProductRequest;
import com.sd61.urbankicks.features.product.dtos.requests.updates.UpdateProductRequest;
import com.sd61.urbankicks.features.product.dtos.responses.ProductResponse;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ProductService {
    ProductResponse createProduct(CreateProductRequest request);

    ProductResponse updateProduct(UpdateProductRequest request);

    Page<ProductResponse> filter(ProductFilterRequest request);

    ProductResponse getDetail(UUID id);
}
