package com.dddproject.store.infrastructure.persistence.repository;

import com.dddproject.store.application.port.out.PriceRepository;
import com.dddproject.store.domain.model.Price;
import com.dddproject.store.infrastructure.mapper.price.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PricePersistenceAdapter implements PriceRepository {

    private final SpringDataPriceRepository springDataPriceRepository;
    private final PriceMapper priceMapper;

    @Autowired
    public PricePersistenceAdapter(SpringDataPriceRepository springDataPriceRepository, PriceMapper priceMapper) {
        this.springDataPriceRepository = springDataPriceRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    public List<Price> findAll() {
        return springDataPriceRepository.findAll().stream()
                .map(priceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Price> findApplicablePrices(Long productId, Long brandId, LocalDateTime date) {
        return springDataPriceRepository.findApplicablePrices(productId, brandId, date).stream()
                .map(priceMapper::toDomain)
                .collect(Collectors.toList());
    }
}