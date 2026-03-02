package com.sd61.urbankicks.features.product.controllers;

import com.sd61.urbankicks.entity.Brand;
import com.sd61.urbankicks.features.product.dtos.BrandDTO;
import com.sd61.urbankicks.features.product.services.IBrandService;
import com.sd61.urbankicks.responses.ResponseData;
import com.sd61.urbankicks.utils.ResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.prefix}/brands")
@RequiredArgsConstructor

public class BrandController {
    private final IBrandService brandService;
    @GetMapping("")
    public ResponseEntity<ResponseData<List<Brand>>> getAllCategories(){
        return ResponseUtil.success( brandService.getAllBrands(),"Success",HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseData<Brand>> createBrand(
            @Valid @RequestBody BrandDTO brandDTO
    ){
        return  ResponseUtil.success(brandService.createBrand(brandDTO),"Create Success",HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Brand>> getBrandById(
            @PathVariable("id") UUID brandId
    ){
        return  ResponseUtil.success(
                brandService.getBrandById(brandId),
                "Brand",
                HttpStatus.FOUND
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseData<Brand>> updateBrand(
            @PathVariable("id") UUID brandId,
            @Valid @RequestBody BrandDTO brandDTO
    ){
        return  ResponseUtil.success(
                brandService.updateBrand(brandId,brandDTO),
                "Cập nhật thành công",
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<Brand>> deleteBrand(
            @PathVariable("id") UUID brandId

    ){
        return  ResponseUtil.success(
                brandService.deleteBrand(brandId),
                "Xóa thành công",
                HttpStatus.OK
        );
    }
}
