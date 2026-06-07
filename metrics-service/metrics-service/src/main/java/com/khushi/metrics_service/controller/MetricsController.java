package com.khushi.metrics_service.controller;

import com.khushi.metrics_service.model.MetricRecord;
import com.khushi.metrics_service.model.MetricsSummary;
import com.khushi.metrics_service.service.MetricsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    private final MetricsService metricsService;

    public MetricsController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @PostMapping
    public String addMetric(@RequestBody MetricRecord metricRecord) {

        metricsService.addMetric(metricRecord);

        return "Metric stored successfully";
    }

    @GetMapping
    public List<MetricRecord> getAllMetrics() {

        return metricsService.getAllMetrics();
    }

    @GetMapping("/summary")
    public MetricsSummary getSummary() {

        return metricsService.getSummary();
    }
}