package com.dddproject.store.infrastructure.web.controller;

import com.dddproject.store.application.port.in.PriceQueryService;
import com.dddproject.store.domain.model.Price;
import com.dddproject.store.infrastructure.mapper.price.PriceResponseMapper;
import com.dddproject.store.infrastructure.web.dto.price.PriceResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

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

    private LocalDateTime testDate = LocalDateTime.of(2023, 1, 1, 10, 0);
    private Long productId = 1L;
    private Long brandId = 1L;

    @Test
    void getApplicablePrice() throws Exception {
        Price mockPrice = new Price();
        PriceResponseDto mockDto = new PriceResponseDto();

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