package com.dddproject.store.application.service;

import com.dddproject.store.domain.model.Price;
import com.dddproject.store.domain.exception.PriceNotFoundException;
import com.dddproject.store.infrastructure.mapper.price.PriceMapper;
import com.dddproject.store.infrastructure.mapper.price.PriceResponseMapper;
import com.dddproject.store.infrastructure.persistence.entity.PriceEntity;
import com.dddproject.store.infrastructure.persistence.repository.SpringDataPriceRepository;
import com.dddproject.store.infrastructure.web.dto.price.PriceResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PriceQueryServiceImplTest {
    @Mock
    private SpringDataPriceRepository priceRepository;

    @Mock
    private PriceMapper priceMapper;

    @Mock
    private PriceResponseMapper priceResponseMapper;

    @InjectMocks
    private PriceQueryServiceImpl priceQueryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindPriceAt10h14thFor35455Product() {
        LocalDateTime testDate = LocalDateTime.of(2023, 6, 14, 10, 0);
        Long productId = 35455L;
        Long brandId = 1L;
        PriceEntity mockPriceEntity = new PriceEntity();
        Price mockPrice = new Price();
        PriceResponseDto mockPriceResponse = new PriceResponseDto();

        when(priceRepository.findApplicablePrices(productId, brandId, testDate))
                .thenReturn(Collections.singletonList(mockPriceEntity));

        when(priceMapper.toDomain(mockPriceEntity)).thenReturn(mockPrice);

        when(priceResponseMapper.convertToDto(mockPrice)).thenReturn(mockPriceResponse);

        Price result = priceQueryService.findApplicablePrice(testDate, productId, brandId);

        assertNotNull(result, "Result must be not null");
        verify(priceRepository).findApplicablePrices(productId, brandId, testDate);
    }

    @Test
    void testFindPriceAt16h14thFor35455Product() {
        LocalDateTime testDate = LocalDateTime.of(2023, 6, 14, 16, 0);
        Long productId = 35455L;
        Long brandId = 1L;
        PriceEntity mockPriceEntity = new PriceEntity();
        Price mockPrice = new Price();
        PriceResponseDto mockPriceResponse = new PriceResponseDto();

        when(priceRepository.findApplicablePrices(productId, brandId, testDate))
                .thenReturn(Collections.singletonList(mockPriceEntity));

        when(priceMapper.toDomain(mockPriceEntity)).thenReturn(mockPrice);

        when(priceResponseMapper.convertToDto(mockPrice)).thenReturn(mockPriceResponse);

        Price result = priceQueryService.findApplicablePrice(testDate, productId, brandId);

        assertNotNull(result, "Result must be not null");
        verify(priceRepository).findApplicablePrices(productId, brandId, testDate);
    }

    @Test
    void testFindPriceAt21h14thFor35455Product() {
        LocalDateTime testDate = LocalDateTime.of(2023, 6, 14, 21, 0);
        Long productId = 35455L;
        Long brandId = 1L;
        PriceEntity mockPriceEntity = new PriceEntity();
        Price mockPrice = new Price();
        PriceResponseDto mockPriceResponse = new PriceResponseDto();

        when(priceRepository.findApplicablePrices(productId, brandId, testDate))
                .thenReturn(Collections.singletonList(mockPriceEntity));

        when(priceMapper.toDomain(mockPriceEntity)).thenReturn(mockPrice);

        when(priceResponseMapper.convertToDto(mockPrice)).thenReturn(mockPriceResponse);

        Price result = priceQueryService.findApplicablePrice(testDate, productId, brandId);

        assertNotNull(result, "Result must be not null");
        verify(priceRepository).findApplicablePrices(productId, brandId, testDate);
    }

    @Test
    void testFindPriceAt10h15thFor35455Product() {
        LocalDateTime testDate = LocalDateTime.of(2023, 6, 15, 10, 0);
        Long productId = 35455L;
        Long brandId = 1L;
        PriceEntity mockPriceEntity = new PriceEntity();
        Price mockPrice = new Price();
        PriceResponseDto mockPriceResponse = new PriceResponseDto();

        when(priceRepository.findApplicablePrices(productId, brandId, testDate))
                .thenReturn(Collections.singletonList(mockPriceEntity));

        when(priceMapper.toDomain(mockPriceEntity)).thenReturn(mockPrice);

        when(priceResponseMapper.convertToDto(mockPrice)).thenReturn(mockPriceResponse);

        Price result = priceQueryService.findApplicablePrice(testDate, productId, brandId);

        assertNotNull(result, "Result must be not null");
        verify(priceRepository).findApplicablePrices(productId, brandId, testDate);
    }

    @Test
    void testFindPriceAt21h16thFor35455Product() {
        LocalDateTime testDate = LocalDateTime.of(2023, 6, 16, 21, 0);
        Long productId = 35455L;
        Long brandId = 1L;
        PriceEntity mockPriceEntity = new PriceEntity();
        Price mockPrice = new Price();
        PriceResponseDto mockPriceResponse = new PriceResponseDto();

        when(priceRepository.findApplicablePrices(productId, brandId, testDate))
                .thenReturn(Collections.singletonList(mockPriceEntity));

        when(priceMapper.toDomain(mockPriceEntity)).thenReturn(mockPrice);

        when(priceResponseMapper.convertToDto(mockPrice)).thenReturn(mockPriceResponse);

        Price result = priceQueryService.findApplicablePrice(testDate, productId, brandId);

        assertNotNull(result, "Result must be not null");
        verify(priceRepository).findApplicablePrices(productId, brandId, testDate);
    }

    @Test
    void findApplicablePricesWhenNotFoundTest() {
        LocalDateTime testDate = LocalDateTime.of(2023, 1, 1, 10, 0);
        Long productId = 1L;
        Long brandId = 1L;

        Exception exception = assertThrows(PriceNotFoundException.class, () -> {
            priceQueryService.findApplicablePrice(testDate, productId, brandId);
        });

        assertTrue(exception.getMessage().contains("No applicable price found for the given criteria."));
    }
}