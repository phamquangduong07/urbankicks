package com.sd61.urbankicks.features.product.dtos.requests.updates;

import com.sd61.urbankicks.features.product.dtos.requests.creates.CreateImageRequest;
import com.sd61.urbankicks.features.product.dtos.requests.creates.CreateVariantRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductRequest {
    @NotNull(message = "Product id is required")
    private UUID id;

    @Size(max = 255, message = "Code must be less than 255 characters")
    private String code;

    @Size(max = 255, message = "Name must be less than 255 characters")
    private String name;

    private UUID brandId;

    private UUID categoryId;

    @Size(max = 2000)
    private String description;

    private Integer status = 1;

    private List<CreateVariantRequest> variants;

    private List<CreateImageRequest> images;
}
