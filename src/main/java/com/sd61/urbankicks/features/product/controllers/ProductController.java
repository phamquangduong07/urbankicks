package com.sd61.urbankicks.features.product.controllers;


import com.sd61.urbankicks.features.product.dtos.requests.creates.CreateProductRequest;
import com.sd61.urbankicks.features.product.dtos.responses.ProductResponse;
import com.sd61.urbankicks.features.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefix}/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductResponse createProduct(
            @RequestBody CreateProductRequest request
    ){
        return productService.createProduct(request);
    }

}
