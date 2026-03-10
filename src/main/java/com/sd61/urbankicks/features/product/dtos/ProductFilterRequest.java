package com.sd61.urbankicks.features.product.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductFilterRequest {
    private String keyword;

    private UUID brandId;

    private UUID categoryId;

    private Integer status;

    private UUID colorId;

    private UUID sizeId;

    private BigDecimal minPrice;

    private BigDecimal maxPrice;

    private Integer page = 0;

    private Integer size = 10;

    private String sortBy = "createdAt";

    private String sortDirection = "DESC";
}
