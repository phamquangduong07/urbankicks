package com.sd61.urbankicks.features.product.dtos.responses;

import com.sd61.urbankicks.responses.BaseResponse;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductVariantResponse extends BaseResponse {
    private UUID id;

    private UUID sizeId;

    private UUID colorId;

    private BigDecimal price;

    private BigDecimal cost;

    private Integer stock;

    private Integer status;
}
