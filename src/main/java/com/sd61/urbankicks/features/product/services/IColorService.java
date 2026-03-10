package com.sd61.urbankicks.features.product.services;

import com.sd61.urbankicks.entity.Color;
import com.sd61.urbankicks.features.product.dtos.requests.ColorRequest;

import java.util.List;
import java.util.UUID;

public interface IColorService {
    Color createColor(ColorRequest dto);

    List<Color> getAllColors();

    Color getColorById(UUID id);

    Color updateColor(UUID id, ColorRequest dto);

    Color deleteColor(UUID id);
}
