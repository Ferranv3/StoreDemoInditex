package com.dddproject.store.application.service;

import com.dddproject.store.application.port.in.PriceQueryService;
import com.dddproject.store.application.port.out.PriceRepository;
import com.dddproject.store.domain.exception.PriceNotFoundException;
import com.dddproject.store.domain.model.Price;
import com.dddproject.store.infrastructure.mapper.price.PriceMapper;
import com.dddproject.store.infrastructure.persistence.entity.PriceEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceQueryServiceImpl implements PriceQueryService {

    private final PriceRepository priceRepository;

    private final PriceMapper priceMapper;

    public PriceQueryServiceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    public List<Price> findAllPrices() {
        return priceRepository.findAll().stream()
                .map(priceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Price findApplicablePrice(LocalDateTime date, Long productId, Long brandId) {
        List<PriceEntity> prices = priceRepository.findApplicablePrices(productId, brandId, date);

        if (prices.isEmpty()) {
            throw new PriceNotFoundException("No applicable price found for the given criteria.");
        }

        return priceMapper.toDomain(prices.get(0));
    }
}
