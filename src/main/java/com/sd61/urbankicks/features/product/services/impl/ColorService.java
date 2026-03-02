package com.sd61.urbankicks.features.product.services.impl;

import com.sd61.urbankicks.entity.Color;
import com.sd61.urbankicks.exceptions.DataNotFoundException;
import com.sd61.urbankicks.features.product.dtos.ColorDTO;
import com.sd61.urbankicks.features.product.repositories.ColorRepository;
import com.sd61.urbankicks.features.product.services.IColorService;
import com.sd61.urbankicks.utils.ValidationCollector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ColorService implements IColorService {
    private final ColorRepository colorRepository;

    @Override
    public Color createColor(ColorDTO dto) {
        ValidationCollector validator = new ValidationCollector();

        validator

                .check(colorRepository.existsByNameIgnoreCase(dto.getName()),
                        "name",
                        "Tên màu đã tồn tại")

                .check(colorRepository.existsByHexCodeIgnoreCase(dto.getHexCode()),
                        "hexCode",
                        "Mã màu đã tồn tại");

        validator.validate();

        Color color = Color.builder()
                .name(dto.getName())
                .hexCode(dto.getHexCode())
                .status(dto.getStatus())
                .build();

        return colorRepository.save(color);
    }

    @Override
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public Color getColorById(UUID id) {
        return colorRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy màu sắc"));
    }

    @Override
    public Color updateColor(UUID id, ColorDTO dto) {
        Color existing = getColorById(id);

        ValidationCollector validator = new ValidationCollector();

        validator

                .check(colorRepository.existsByNameIgnoreCaseAndIdNot(dto.getName(), id),
                        "name",
                        "Tên màu đã tồn tại")

                .check(colorRepository.existsByHexCodeIgnoreCaseAndIdNot(dto.getHexCode(), id),
                        "hexCode",
                        "Mã màu đã tồn tại");

        validator.validate();
        existing.setName(dto.getName());
        existing.setHexCode(dto.getHexCode());
        existing.setStatus(dto.getStatus());

        return colorRepository.save(existing);
    }

    @Override
    public Color deleteColor(UUID id) {
        Color existing = getColorById(id);
        existing.setStatus(0);
      return   colorRepository.save(existing);
    }

}
