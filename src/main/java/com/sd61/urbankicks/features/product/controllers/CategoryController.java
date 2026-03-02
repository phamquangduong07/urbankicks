package com.sd61.urbankicks.features.product.controllers;

import com.sd61.urbankicks.entity.Category;
import com.sd61.urbankicks.features.product.dtos.CategoryDTO;
import com.sd61.urbankicks.features.product.services.ICategoryService;
import com.sd61.urbankicks.responses.ResponseData;
import com.sd61.urbankicks.utils.ResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.prefix}/categories")
@RequiredArgsConstructor
@Validated
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<ResponseData<List<Category>>> getAllCategories(){
        return ResponseUtil.success( categoryService.getAllCategories(),"Success",HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseData<Category>> createCategory(
            @Valid  @RequestBody CategoryDTO categoryDTO
    ){
    return  ResponseUtil.success(categoryService.createCategory(categoryDTO),"Create Success",HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Category>> getCategoryById(
            @PathVariable("id") UUID categoryId
            ){
        return  ResponseUtil.success(
                categoryService.getCategoryById(categoryId),
                "Category",
                HttpStatus.FOUND
                );
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseData<Category>> updateCategory(
            @PathVariable("id") UUID categoryId,
            @Valid @RequestBody CategoryDTO categoryDTO
    ){
        return  ResponseUtil.success(
                categoryService.updateCategory(categoryId,categoryDTO),
                "Cập nhật thành công",
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<Category>> deleteCategory(
            @PathVariable("id") UUID categoryId

    ){
        return  ResponseUtil.success(
                categoryService.deleteCategory(categoryId),
                "Xóa thành công",
                HttpStatus.OK
        );
    }
}
