package com.sd61.urbankicks.features.product.dtos.responses;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageResponse {

    private UUID id;

    private UUID colorId;

    private String imageUrl;

    private Boolean isThumbnail;
}
