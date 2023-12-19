package com.dddproject.store.infrastructure.mapper.price;

import com.dddproject.store.domain.model.Price;
import com.dddproject.store.infrastructure.web.dto.price.PriceResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PriceResponseMapper {

    public PriceResponseDto convertToDto(Price price) {
        PriceResponseDto dto = new PriceResponseDto();
        dto.setProductId(price.getProductId());
        dto.setBrandId(price.getId());
        dto.setPriceList(price.getPriceList());
        dto.setStartDate(price.getStartDate());
        dto.setEndDate(price.getEndDate());
        dto.setPrice(price.getPrice());
        return dto;
    }

    public List<PriceResponseDto> convertToDtos(List<Price> prices) {
        return prices.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}