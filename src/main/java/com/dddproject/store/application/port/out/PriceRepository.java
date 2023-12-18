package com.dddproject.store.application.port.out;

import com.dddproject.store.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
    List<Price> findAll();
    List<Price> findApplicablePrices(Long productId, Long brandId, LocalDateTime date);
}
