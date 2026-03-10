package com.sd61.urbankicks.features.product.services.impl;

import com.sd61.urbankicks.entity.Size;
import com.sd61.urbankicks.exceptions.DataNotFoundException;
import com.sd61.urbankicks.exceptions.DuplicateResourceException;
import com.sd61.urbankicks.features.product.dtos.requests.SizeRequest;
import com.sd61.urbankicks.features.product.repositories.SizeRepository;
import com.sd61.urbankicks.features.product.services.ISizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SizeServiceImpl implements ISizeService {
    private final SizeRepository sizeRepository;
    @Override
    public Size createSize(SizeRequest dto) {

        if (sizeRepository.existsSizeBySizeValue(dto.getSizeValue())) {
            throw new DuplicateResourceException("Size đã tồn tại");
        }

        Size newSize = Size.builder()
                .sizeValue(dto.getSizeValue())
                .status(dto.getStatus())
                .build();

        return sizeRepository.save(newSize);
    }

    @Override
    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getSizeById(UUID id) {
        return sizeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy size"));
    }

    @Override
    public Size updateSize(UUID id, SizeRequest dto) {
        Size existingSize = getSizeById(id);

        if (sizeRepository.existsBySizeValueAndIdNot(dto.getSizeValue(), id)) {
            throw new DuplicateResourceException("Size đã tồn tại");
        }

        existingSize.setSizeValue(dto.getSizeValue());
        existingSize.setStatus(dto.getStatus());

        return sizeRepository.save(existingSize);
    }

    @Override
    public Size deleteSize(UUID id) {
        Size existingSize = getSizeById(id);
        existingSize.setStatus(0);
        return sizeRepository.save(existingSize);
    }

    @Override
    public List<Size> sortByValue() {
        return sizeRepository.findAll(Sort.by(Sort.Direction.ASC, "sizeValue"));
    }
}
