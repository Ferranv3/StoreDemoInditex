package com.dddproject.store.infrastructure.mapper.brand;

import com.dddproject.store.domain.model.Brand;
import com.dddproject.store.infrastructure.persistence.entity.BrandEntity;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {

    public Brand toDomain(BrandEntity entity) {
        Brand product = new Brand();
        product.setId(entity.getId());
        product.setName(entity.getName());
        return product;
    }
}
