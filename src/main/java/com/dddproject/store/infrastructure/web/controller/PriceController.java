package com.dddproject.store.infrastructure.web.controller;

import com.dddproject.store.application.port.in.PriceQueryService;
import com.dddproject.store.domain.model.Price;
import com.dddproject.store.infrastructure.mapper.price.PriceResponseMapper;
import com.dddproject.store.infrastructure.web.dto.price.PriceResponseDto;
import com.dddproject.store.infrastructure.web.dto.price.PriceRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {
    private final PriceQueryService priceQueryService;
    private final PriceResponseMapper priceResponseMapper;

    public PriceController(PriceQueryService priceQueryService, PriceResponseMapper priceResponseMapper) {
        this.priceQueryService = priceQueryService;
        this.priceResponseMapper = priceResponseMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PriceResponseDto>> getAllPrices() {
        List<Price> prices = priceQueryService.findAllPrices();
        return ResponseEntity.ok(priceResponseMapper.convertToDtos(prices));
    }

    @GetMapping("/applicable")
    public ResponseEntity<PriceResponseDto> getApplicablePrice(@RequestParam LocalDateTime date,
                                                     @RequestParam Long productId,
                                                     @RequestParam Long brandId) {
        Price price = priceQueryService.findApplicablePrice(date, productId, brandId);
        return ResponseEntity.ok(priceResponseMapper.convertToDto(price));
    }

    @GetMapping("/price")
    public ResponseEntity<PriceResponseDto> getPrice(@RequestParam PriceRequestDto priceRequestDto) {
        Price price = priceQueryService.findApplicablePrice(priceRequestDto.getDate(), priceRequestDto.getProductId(), priceRequestDto.getBrandId());
        return ResponseEntity.ok(priceResponseMapper.convertToDto(price));
    }
}
