package com.dddproject.store.infrastructure.web.controller;

import com.dddproject.store.application.port.in.PriceQueryService;
import com.dddproject.store.domain.model.Price;
import com.dddproject.store.infrastructure.mapper.price.PriceResponseMapper;
import com.dddproject.store.infrastructure.web.dto.price.PriceResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/prices")
@Tag(name = "Prices", description = "Prices Api")
public class PriceController {
    private final PriceQueryService priceQueryService;
    private final PriceResponseMapper priceResponseMapper;

    public PriceController(PriceQueryService priceQueryService, PriceResponseMapper priceResponseMapper) {
        this.priceQueryService = priceQueryService;
        this.priceResponseMapper = priceResponseMapper;
    }

    @GetMapping("/applicable")
    @Operation(summary = "Get Applicable Price", description = "Retrieve the applicable price for the given date, product ID, and brand ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the applicable price",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PriceResponseDto.class)))
    public ResponseEntity<PriceResponseDto> getApplicablePrice(
            @Parameter(description = "Date for which the price is applicable")
            @RequestParam LocalDateTime date,
            @Parameter(description = "Product ID")
            @RequestParam Long productId,
            @Parameter(description = "Brand ID")
            @RequestParam Long brandId) {
        Price price = priceQueryService.findApplicablePrice(date, productId, brandId);
        return ResponseEntity.ok(priceResponseMapper.convertToDto(price));
    }
}
