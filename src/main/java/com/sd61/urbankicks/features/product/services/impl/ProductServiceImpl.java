package com.sd61.urbankicks.features.product.services.impl;

import com.sd61.urbankicks.entity.*;
import com.sd61.urbankicks.features.product.dtos.ProductFilterRequest;
import com.sd61.urbankicks.features.product.dtos.requests.creates.CreateProductRequest;
import com.sd61.urbankicks.features.product.dtos.requests.updates.UpdateProductRequest;
import com.sd61.urbankicks.features.product.dtos.responses.ProductResponse;
import com.sd61.urbankicks.features.product.mapper.ImageMapper;
import com.sd61.urbankicks.features.product.mapper.ProductMapper;
import com.sd61.urbankicks.features.product.mapper.VariantMapper;
import com.sd61.urbankicks.features.product.repositories.*;
import com.sd61.urbankicks.features.product.services.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ProductVariantRepository productVariantRepository;
    private final ProductImageRepository productImageRepository;
    private final SizeRepository sizeRepository;
    private final ColorRepository colorRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {

        Product product = new Product();
        product.setCode(request.getCode());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        Brand brand = brandRepository.getReferenceById(request.getBrandId());
        Category category = categoryRepository.getReferenceById(request.getCategoryId());
        product.setBrand(brand);
        product.setCategory(category);
        product.setStatus(request.getStatus());
        productRepository.save(product);
        List<ProductVariant> variants = request.getVariants()
                .stream()
                .map(
                        v -> {
                            Size size = sizeRepository.getReferenceById(v.getSizeId());
                            Color color = colorRepository.getReferenceById(v.getColorId());
                            return VariantMapper.toEntity(product, v, size, color);
                        }
                )
                .toList();
        productVariantRepository.saveAll(variants);
        List<ProductImage> images = request.getImages()
                .stream()
                .map(img ->{
                    Color color = colorRepository.getReferenceById(img.getColorId());
                    return ImageMapper.toEntity(product, img, color);
                        }

                )
                .toList();

        productImageRepository.saveAll(images);
        return ProductResponse.mapResponse(product, variants, images);
    }

    @Override
    public ProductResponse updateProduct(UpdateProductRequest request) {
        return null;
    }

    @Override
    public Page<ProductResponse> filter(ProductFilterRequest request) {
        return null;
    }

    @Override
    public ProductResponse getDetail(UUID id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        List<ProductVariant> variants =
                productVariantRepository.findAllByProductId(id);

        List<ProductImage> images =
                productImageRepository.findAllByProductId(id);

        return ProductResponse.mapResponse(product, variants, images);
    }
}
