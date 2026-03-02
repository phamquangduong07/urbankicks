package com.sd61.urbankicks.features.product.dtos;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;



@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    @NotBlank(message = "Tên danh mục không được để trống")
    @Size(max = 255, message = "Tên danh mục tối đa 255 ký tự")
    private String name;

    @NotNull(message = "Trạng thái không được để trống")
    private Integer status;
}