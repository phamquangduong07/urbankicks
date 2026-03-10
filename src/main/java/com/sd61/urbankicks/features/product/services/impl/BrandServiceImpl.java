package com.sd61.urbankicks.features.product.services.impl;

import com.sd61.urbankicks.entity.Brand;
import com.sd61.urbankicks.exceptions.DataNotFoundException;
import com.sd61.urbankicks.exceptions.DuplicateResourceException;
import com.sd61.urbankicks.features.product.dtos.requests.BrandRequest;
import com.sd61.urbankicks.features.product.repositories.BrandRepository;
import com.sd61.urbankicks.features.product.services.IBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements IBrandService {
    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand createBrand(BrandRequest brandDTO) {
        if(brandRepository.existsBrandByNameIgnoreCase(brandDTO.getName())){
            throw new DuplicateResourceException("Tên thương hiệu đã tồn tại");
        }
        Brand newBrand = Brand.builder()
                .name(brandDTO.getName())
                .status(brandDTO.getStatus())
                .build();
        return brandRepository.save(newBrand);
    }

    @Override
    public Brand updateBrand(UUID id, BrandRequest brandDTO) {
        Brand existingBrand = getBrandById(id);
        if(brandRepository.existsBrandByNameIgnoreCaseAndIdNot(brandDTO.getName(),id)){
            throw new DuplicateResourceException("Tên thương hiệu đã tồn tại");
        }
        existingBrand.setName(brandDTO.getName());
        existingBrand.setStatus(brandDTO.getStatus());
        return brandRepository.save(existingBrand);
    }

    @Override
    public Brand deleteBrand(UUID uuid) {
        Brand existingBrand = getBrandById(uuid);
        existingBrand.setStatus(0);
        return brandRepository.save(existingBrand);
    }

    @Override
    public Brand getBrandById(UUID uuid) {
        return brandRepository.findById(uuid).orElseThrow(()-> new DataNotFoundException("Không tìm thấy thương hiệu"));
    }
}
