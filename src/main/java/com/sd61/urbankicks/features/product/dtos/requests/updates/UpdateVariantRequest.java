package com.sd61.urbankicks.features.product.dtos.requests.updates;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateVariantRequest {
    private UUID id;

    @NotNull(message = "Size không được để trống")
    @JsonProperty("size_id")
    private UUID sizeId;

    @NotNull(message = "Màu sắc không được để trống")
    @JsonProperty("color_id")
    private UUID colorId;

    @NotNull(message = "Giá bán không được để trống")
    @DecimalMin(value = "0.0", inclusive = true, message = "Giá phải >= 0")
    private BigDecimal price;

    @DecimalMin(value = "0.0", inclusive = true, message = "Giá nhập phải >= 0")
    private BigDecimal cost;

    @Min(value = 0, message = "Số lượng phải >= 0")
    private Integer stock;

    @NotNull(message = "Status không được để trống")
    private Integer status;
}
