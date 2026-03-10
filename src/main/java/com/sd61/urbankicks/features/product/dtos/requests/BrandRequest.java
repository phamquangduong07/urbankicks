package com.sd61.urbankicks.features.product.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandRequest {
    @NotBlank(message = "Tên thương hiệu không được để trống")
    @Size(max = 255, message = "Tên thương hiệu tối đa 255 ký tự")
    private String name;

    @NotNull(message = "Trạng thái không được để trống")
    private Integer status;
}
