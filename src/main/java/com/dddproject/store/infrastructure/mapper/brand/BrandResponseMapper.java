package com.dddproject.store.infrastructure.mapper.brand;

import com.dddproject.store.domain.model.Brand;
import com.dddproject.store.infrastructure.web.dto.BrandResponseDto;
import org.springframework.stereotype.Component;

@Component
public class BrandResponseMapper {

    public BrandResponseDto convertToDto(Brand brand) {
        BrandResponseDto dto = new BrandResponseDto();
        dto.setId(brand.getId());
        dto.setName(brand.getName());
        return dto;
    }
}