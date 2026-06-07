package com.khushi.metrics_service.repository;

import com.khushi.metrics_service.model.MetricRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends JpaRepository<MetricRecord, Long> {
}