package com.sd61.urbankicks.features.product.services;

import com.sd61.urbankicks.entity.Color;
import com.sd61.urbankicks.features.product.dtos.ColorDTO;

import java.util.List;
import java.util.UUID;

public interface IColorService {
    Color createColor(ColorDTO dto);

    List<Color> getAllColors();

    Color getColorById(UUID id);

    Color updateColor(UUID id, ColorDTO dto);

    Color deleteColor(UUID id);
}
