package com.sd61.urbankicks.features.product.services;

import com.sd61.urbankicks.entity.Brand;
import com.sd61.urbankicks.features.product.dtos.requests.BrandRequest;

import java.util.List;
import java.util.UUID;

public interface IBrandService {
    List<Brand> getAllBrands();
    Brand createBrand(BrandRequest brandDTO);
    Brand updateBrand(UUID id, BrandRequest brandDTO);
    Brand deleteBrand(UUID uuid);
    Brand getBrandById(UUID uuid);
}
