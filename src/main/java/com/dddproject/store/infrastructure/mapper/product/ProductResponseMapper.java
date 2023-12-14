package com.dddproject.store.infrastructure.mapper.product;

import com.dddproject.store.domain.model.Product;
import com.dddproject.store.infrastructure.web.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseMapper {

    public ProductResponseDto convertToDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getProductId());
        dto.setName(product.getName());
        return dto;
    }
}