package com.sd61.urbankicks.features.product.services;

import com.sd61.urbankicks.entity.Size;
import com.sd61.urbankicks.features.product.dtos.requests.SizeRequest;

import java.util.List;
import java.util.UUID;

public interface ISizeService {
    Size createSize(SizeRequest dto);

    List<Size> getAllSizes();

    Size getSizeById(UUID id);

    Size updateSize(UUID id, SizeRequest dto);

    Size deleteSize(UUID id);

    List<Size> sortByValue();
}
