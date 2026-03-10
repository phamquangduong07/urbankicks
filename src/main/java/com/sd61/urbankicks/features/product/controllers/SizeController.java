package com.sd61.urbankicks.features.product.controllers;

import com.sd61.urbankicks.entity.Size;
import com.sd61.urbankicks.features.product.dtos.requests.SizeRequest;
import com.sd61.urbankicks.features.product.services.ISizeService;
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
@RequestMapping("${api.prefix}/sizes")
@RequiredArgsConstructor
public class SizeController {
    private final ISizeService sizeService;

    @GetMapping("")
    public ResponseEntity<ResponseData<List<Size>>> getAllSize(){
        return ResponseUtil.success( sizeService.sortByValue(),"Success", HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseData<Size>> createSize(
            @Valid @RequestBody SizeRequest dto
    ){
        return  ResponseUtil.success(sizeService.createSize(dto),"Create Success",HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Size>> getSizeById(
            @PathVariable("id") UUID id
    ){
        return  ResponseUtil.success(
                sizeService.getSizeById(id),
                "Size",
                HttpStatus.FOUND
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseData<Size>> updateCategory(
            @PathVariable("id") UUID sizeId,
            @Valid @RequestBody SizeRequest sizeRequest
    ){
        return  ResponseUtil.success(
                sizeService.updateSize(sizeId, sizeRequest),
                "Cập nhật thành công",
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<Size>> deleteCategory(
            @PathVariable("id") UUID sizeId

    ){
        return  ResponseUtil.success(
                sizeService.deleteSize(sizeId),
                "Xóa thành công",
                HttpStatus.OK
        );
    }
}
