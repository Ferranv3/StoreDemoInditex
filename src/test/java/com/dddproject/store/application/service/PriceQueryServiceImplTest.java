package com.dddproject.store.application.service;

import com.dddproject.store.domain.model.Price;
import com.dddproject.store.domain.exception.PriceNotFoundException;
import com.dddproject.store.infrastructure.persistence.repository.PricePersistenceAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceQueryServiceImplTest {
    @Mock
    private PricePersistenceAdapter pricePersistenceAdapter;

    @InjectMocks
    private PriceQueryServiceImpl priceQueryService;

    private final Long productId = 35455L;
    private final Long brandId = 1L;
    private Price mockPrice;

    @BeforeEach
    void setUp() {
        mockPrice = new Price();
    }

    @Test
    void testFindPriceAt10h14thFor35455Product() {
        LocalDateTime testDate = LocalDateTime.of(2023, 6, 14, 10, 0);

        when(pricePersistenceAdapter.findApplicablePrices(productId, brandId, testDate))
                .thenReturn(Collections.singletonList(mockPrice));

        Price result = priceQueryService.findApplicablePrice(testDate, productId, brandId);

        assertNotNull(result, "Result must be not null");
        verify(pricePersistenceAdapter).findApplicablePrices(productId, brandId, testDate);
    }

    @Test
    void testFindPriceAt16h14thFor35455Product() {
        LocalDateTime testDate = LocalDateTime.of(2023, 6, 14, 16, 0);

        when(pricePersistenceAdapter.findApplicablePrices(productId, brandId, testDate))
                .thenReturn(Collections.singletonList(mockPrice));

        Price result = priceQueryService.findApplicablePrice(testDate, productId, brandId);

        assertNotNull(result, "Result must be not null");
        verify(pricePersistenceAdapter).findApplicablePrices(productId, brandId, testDate);
    }

    @Test
    void testFindPriceAt21h14thFor35455Product() {
        LocalDateTime testDate = LocalDateTime.of(2023, 6, 14, 21, 0);

        when(pricePersistenceAdapter.findApplicablePrices(productId, brandId, testDate))
                .thenReturn(Collections.singletonList(mockPrice));

        Price result = priceQueryService.findApplicablePrice(testDate, productId, brandId);

        assertNotNull(result, "Result must be not null");
        verify(pricePersistenceAdapter).findApplicablePrices(productId, brandId, testDate);
    }

    @Test
    void testFindPriceAt10h15thFor35455Product() {
        LocalDateTime testDate = LocalDateTime.of(2023, 6, 15, 10, 0);

        when(pricePersistenceAdapter.findApplicablePrices(productId, brandId, testDate))
                .thenReturn(Collections.singletonList(mockPrice));

        Price result = priceQueryService.findApplicablePrice(testDate, productId, brandId);

        assertNotNull(result, "Result must be not null");
        verify(pricePersistenceAdapter).findApplicablePrices(productId, brandId, testDate);
    }

    @Test
    void testFindPriceAt21h16thFor35455Product() {
        LocalDateTime testDate = LocalDateTime.of(2023, 6, 16, 21, 0);

        when(pricePersistenceAdapter.findApplicablePrices(productId, brandId, testDate))
                .thenReturn(Collections.singletonList(mockPrice));

        Price result = priceQueryService.findApplicablePrice(testDate, productId, brandId);

        assertNotNull(result, "Result must be not null");
        verify(pricePersistenceAdapter).findApplicablePrices(productId, brandId, testDate);
    }

    @Test
    void findApplicablePricesWhenNotFoundTest() {
        LocalDateTime testDate = LocalDateTime.of(2023, 1, 1, 10, 0);

        Exception exception = assertThrows(PriceNotFoundException.class, () -> {
            priceQueryService.findApplicablePrice(testDate, productId, brandId);
        });

        assertTrue(exception.getMessage().contains("No applicable price found for the given criteria."));
    }
}