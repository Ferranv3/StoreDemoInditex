package com.dddproject.store.infrastructure.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceRequestDto {
    private Long productId;
    private Long brandId;
    private LocalDateTime date;
}
