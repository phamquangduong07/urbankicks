package com.sd61.urbankicks.features.product.services;

import com.sd61.urbankicks.entity.Brand;
import com.sd61.urbankicks.features.product.dtos.BrandDTO;

import java.util.List;
import java.util.UUID;

public interface IBrandService {
    List<Brand> getAllBrands();
    Brand createBrand(BrandDTO brandDTO);
    Brand updateBrand(UUID id, BrandDTO brandDTO);
    Brand deleteBrand(UUID uuid);
    Brand getBrandById(UUID uuid);
}
