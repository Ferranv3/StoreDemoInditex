package com.dddproject.store.infrastructure.mapper.price;

import com.dddproject.store.domain.model.Price;
import com.dddproject.store.infrastructure.persistence.entity.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    public Price toDomain(PriceEntity entity) {
        Price price = new Price();
        price.setId(entity.getId());
        price.setBrandId(entity.getBrandId());
        price.setStartDate(entity.getStartDate());
        price.setEndDate(entity.getEndDate());
        price.setPriceList(entity.getPriceList());
        price.setProductId(entity.getProductId());
        price.setPriority(entity.getPriority());
        price.setPrice(entity.getPrice());
        price.setCurrency(entity.getCurrency());
        return price;
    }
}
