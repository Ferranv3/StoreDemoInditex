package com.dddproject.store.application.port.out;

import com.dddproject.store.infrastructure.persistence.entity.PriceEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
    List<PriceEntity> findAll();
    List<PriceEntity> findApplicablePrices(Long productId, Long brandId, LocalDateTime date);
}
