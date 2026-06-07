package com.khushi.metrics_service.service;

import com.khushi.metrics_service.model.MetricRecord;
import com.khushi.metrics_service.model.MetricsSummary;
import com.khushi.metrics_service.repository.MetricRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricsService {

    private final MetricRepository metricRepository;

    public MetricsService(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    public void addMetric(MetricRecord metricRecord) {
        metricRepository.save(metricRecord);
    }

    public List<MetricRecord> getAllMetrics() {
        return metricRepository.findAll();
    }

    public MetricsSummary getSummary() {

        List<MetricRecord> metrics = metricRepository.findAll();

        int totalChecks = metrics.size();

        int successChecks = 0;
        int failedChecks = 0;
        long totalResponseTime = 0;

        for (MetricRecord metric : metrics) {

            if ("UP".equalsIgnoreCase(metric.getStatus())) {
                successChecks++;
            } else {
                failedChecks++;
            }

            totalResponseTime += metric.getResponseTime();
        }

        double averageResponseTime = 0;

        if (totalChecks > 0) {
            averageResponseTime =
                    (double) totalResponseTime / totalChecks;
        }

        return new MetricsSummary(
                totalChecks,
                successChecks,
                failedChecks,
                averageResponseTime
        );
    }
}