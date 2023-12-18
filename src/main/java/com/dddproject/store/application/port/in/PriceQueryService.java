package com.dddproject.store.application.port.in;

import com.dddproject.store.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceQueryService {
    List<Price> findAllPrices();
    Price findApplicablePrice(LocalDateTime date, Long productId, Long brandId);
}
