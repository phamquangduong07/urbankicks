package com.sd61.urbankicks.features.product.controllers;

import com.sd61.urbankicks.entity.Color;
import com.sd61.urbankicks.features.product.dtos.ColorDTO;
import com.sd61.urbankicks.features.product.services.IColorService;
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
@RequestMapping("${api.prefix}/colors")
@RequiredArgsConstructor

public class ColorController {
    private final IColorService colorService;
    @PostMapping
    public ResponseEntity<ResponseData<Color>> create(
            @Valid @RequestBody ColorDTO dto
    ) {
        return ResponseUtil.success(
                colorService.createColor(dto),
                "Tạo màu thành công",
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<ResponseData<List<Color>>> getAll() {
        return ResponseUtil.success(
                colorService.getAllColors(),
                "Danh sách màu",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Color>> getById(
            @PathVariable UUID id
    ) {
        return ResponseUtil.success(
                colorService.getColorById(id),
                "Chi tiết màu",
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseData<Color>> update(
            @PathVariable UUID id,
            @Valid @RequestBody ColorDTO dto
    ) {
        return ResponseUtil.success(
                colorService.updateColor(id, dto),
                "Cập nhật màu thành công",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<Color>> delete(
            @PathVariable UUID id
    ) {

        return ResponseUtil.success(
                colorService.deleteColor(id),
                "Xóa màu thành công",
                HttpStatus.OK
        );
    }
}
