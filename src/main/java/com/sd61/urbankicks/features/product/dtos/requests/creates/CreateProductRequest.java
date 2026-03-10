package com.sd61.urbankicks.features.product.dtos.requests.creates;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateProductRequest {


    @NotBlank(message = "Mã sản phẩm không được để trống")
    @Size(max = 255, message = "Code must be less than 255 characters")
    private String code;

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 255, message = "Name must be less than 255 characters")
    private String name;

    @NotNull(message = "Thương hiệu không được để trống")
    @JsonProperty("brand_id")
    private UUID brandId;

    @NotNull(message = "Danh mục không được để trống")
    @JsonProperty("category_id")
    private UUID categoryId;

    private String description;

    private Integer status = 1;

    @NotEmpty(message = "Biến thể không được để trống")
    private List<CreateVariantRequest> variants;

    @NotEmpty(message = "Ảnh sản phẩm không được để trống")
    private List<CreateImageRequest> images;

}
