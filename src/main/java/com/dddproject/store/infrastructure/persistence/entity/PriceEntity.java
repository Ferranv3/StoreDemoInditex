package com.dddproject.store.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRICE")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST")
    private Long priceList;

    @JoinColumn(name = "PRODUCT_ID")
    private Long productId;

    private Integer priority;

    private BigDecimal price;

    @Column(name = "CURR")
    private String currency;

    @JoinColumn(name = "BRAND_ID")
    private Long brandId;
}
