package com.dddproject.store.infrastructure.persistence.repository;

import com.dddproject.store.application.port.out.PriceRepository;
import com.dddproject.store.infrastructure.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, Long>, PriceRepository {
    @Query("SELECT p FROM PriceEntity p"
            + " WHERE p.productId.id = :productId AND p.brandId.id = :brandId"
            + " AND :date BETWEEN p.startDate AND p.endDate"
            + " ORDER BY p.priority DESC")
    List<PriceEntity> findApplicablePrices(Long productId, Long brandId, LocalDateTime date);
}