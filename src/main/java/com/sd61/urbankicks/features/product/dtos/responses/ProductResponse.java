package com.sd61.urbankicks.features.product.dtos.responses;

import com.sd61.urbankicks.entity.Product;
import com.sd61.urbankicks.entity.ProductImage;
import com.sd61.urbankicks.entity.ProductVariant;
import com.sd61.urbankicks.responses.BaseResponse;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse extends BaseResponse {
    private UUID id;

    private String code;

    private String name;

    private String description;

    private UUID brandId;

    private UUID categoryId;

    private Integer status;

    private List<ProductVariantResponse> variants;

    private List<ProductImageResponse> images;

    public static ProductResponse mapResponse(Product product,
                                              List<ProductVariant> variants,
                                              List<ProductImage> images) {
       ProductResponse res = new ProductResponse();
         res.setId(product.getId());
        res.setCode(product.getCode());
        res.setName(product.getName());
        res.setDescription(product.getDescription());
        res.setBrandId(product.getBrand().getId());
        res.setCategoryId(product.getCategory().getId());
        res.setStatus(product.getStatus());

        res.setVariants(
               variants.stream().map(
                       v->{
                           ProductVariantResponse variantResponse = new ProductVariantResponse();
                           variantResponse.setId(v.getId());
                           variantResponse.setSizeId(v.getSize().getId());
                           variantResponse.setColorId(v.getColor().getId());
                           variantResponse.setPrice(v.getPrice());
                           variantResponse.setStock(v.getStock());
                           variantResponse.setStatus(v.getStatus());
                           variantResponse.setCost(v.getCost());
                           return variantResponse;
                       }
               ).toList()
        );
        res.setImages(
                images.stream().map(
                    img->{
                        ProductImageResponse imgResponse = new ProductImageResponse();
                        imgResponse.setId(img.getId());
                        imgResponse.setImageUrl(img.getImageUrl());
                        imgResponse.setIsThumbnail(img.getIsThumbnail());
                        return imgResponse;
                    }

                ).toList()
        );
        return res;
    }
}
