package com.dddproject.store.infrastructure.mapper.product;

import com.dddproject.store.domain.model.Product;
import com.dddproject.store.infrastructure.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toDomain(ProductEntity entity) {
        Product product = new Product();
        product.setProductId(entity.getId());
        product.setName(entity.getName());
        return product;
    }
}
