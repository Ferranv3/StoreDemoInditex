package com.dddproject.store.infrastructure.web.controller;

import com.dddproject.store.application.port.in.PriceQueryService;
import com.dddproject.store.domain.model.Price;
import com.dddproject.store.infrastructure.mapper.PriceResponseMapper;
import com.dddproject.store.infrastructure.web.dto.PriceResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PriceController.class)
class PriceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceResponseMapper priceResponseMapper;

    @MockBean
    private PriceQueryService priceQueryService;

    @Test
    void getAllPrices() throws Exception {
        List<Price> mockPrices = Arrays.asList(new Price(), new Price());
        List<PriceResponseDto> mockDtos = Arrays.asList(new PriceResponseDto(), new PriceResponseDto());

        when(priceQueryService.findAllPrices()).thenReturn(mockPrices);
        when(priceResponseMapper.convertToDtos(mockPrices)).thenReturn(mockDtos);

        mockMvc.perform(get("/api/v1/prices/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void getApplicablePrice() throws Exception {
        LocalDateTime testDate = LocalDateTime.of(2023, 1, 1, 10, 0);
        Long productId = 1L;
        Long brandId = 1L;
        Price mockPrice = new Price(); // Suponiendo que Price es tu clase de dominio
        PriceResponseDto mockDto = new PriceResponseDto(); // Suponiendo que este es tu DTO

        when(priceQueryService.findApplicablePrice(testDate, productId, brandId)).thenReturn(mockPrice);
        when(priceResponseMapper.convertToDto(mockPrice)).thenReturn(mockDto);

        mockMvc.perform(get("/api/v1/prices/applicable")
                        .param("date", "2023-01-01T10:00:00")
                        .param("productId", "1")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}