package com.khushi.monitor_service.client;

import com.khushi.monitor_service.model.HealthCheckResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MetricsClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendMetric(HealthCheckResponse response) {

        String metricsServiceUrl =
                "http://metrics-service:8081/metrics";

        restTemplate.postForObject(
                metricsServiceUrl,
                response,
                String.class
        );
    }
}