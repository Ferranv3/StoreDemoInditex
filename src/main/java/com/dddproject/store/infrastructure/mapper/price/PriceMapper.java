package com.dddproject.store.infrastructure.mapper.price;

import com.dddproject.store.domain.model.Price;
import com.dddproject.store.infrastructure.mapper.product.ProductMapper;
import com.dddproject.store.infrastructure.mapper.brand.BrandMapper;
import com.dddproject.store.infrastructure.persistence.entity.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    private final BrandMapper brandMapper;
    private final ProductMapper productMapper;

    public PriceMapper() {
        this.brandMapper = new BrandMapper();
        this.productMapper = new ProductMapper();
    }

    public Price toDomain(PriceEntity entity) {
        Price price = new Price();
        price.setId(entity.getId());
        price.setBrand(brandMapper.toDomain(entity.getBrandId()));
        price.setStartDate(entity.getStartDate());
        price.setEndDate(entity.getEndDate());
        price.setPriceList(entity.getPriceList());
        price.setProduct(productMapper.toDomain(entity.getProductId()));
        price.setPriority(entity.getPriority());
        price.setPrice(entity.getPrice());
        price.setCurrency(entity.getCurrency());
        return price;
    }
}
