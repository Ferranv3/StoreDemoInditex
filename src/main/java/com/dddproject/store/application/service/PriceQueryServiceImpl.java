package com.dddproject.store.application.service;

import com.dddproject.store.application.port.in.PriceQueryService;
import com.dddproject.store.domain.exception.PriceNotFoundException;
import com.dddproject.store.domain.model.Price;
import com.dddproject.store.infrastructure.persistence.repository.PricePersistenceAdapter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceQueryServiceImpl implements PriceQueryService {

    private final PricePersistenceAdapter pricePersistenceAdapter;

    public PriceQueryServiceImpl(PricePersistenceAdapter pricePersistenceAdapter) {
        this.pricePersistenceAdapter = pricePersistenceAdapter;
    }

    @Override
    public List<Price> findAllPrices() {
        return pricePersistenceAdapter.findAll();
    }

    @Override
    public Price findApplicablePrice(LocalDateTime date, Long productId, Long brandId) {
        List<Price> prices = pricePersistenceAdapter.findApplicablePrices(productId, brandId, date);

        if (prices.isEmpty()) {
            throw new PriceNotFoundException("No applicable price found for the given criteria.");
        }

        return prices.get(0);
    }
}
