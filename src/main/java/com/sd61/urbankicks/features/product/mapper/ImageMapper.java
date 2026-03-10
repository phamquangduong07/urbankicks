package com.sd61.urbankicks.features.product.mapper;

import com.sd61.urbankicks.entity.Color;
import com.sd61.urbankicks.entity.Product;
import com.sd61.urbankicks.entity.ProductImage;
import com.sd61.urbankicks.features.product.dtos.requests.creates.CreateImageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ImageMapper {


    public static  ProductImage toEntity(Product product, CreateImageRequest req, Color color) {
        ProductImage img = new ProductImage();
        img.setProductId(product);
        img.setColorId(color);
        img.setImageUrl(req.getImageUrl());
        img.setIsThumbnail(req.getIsThumbnail());

        return img;
    }
}
