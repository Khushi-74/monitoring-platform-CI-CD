package com.khushi.monitor_service.service;

import com.khushi.monitor_service.client.MetricsClient;
import com.khushi.monitor_service.model.HealthCheckResponse;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class MonitorService {

    private final MetricsClient metricsClient;

    public MonitorService(MetricsClient metricsClient) {
        this.metricsClient = metricsClient;
    }

    public HealthCheckResponse checkUrl(String urlString) {

        HealthCheckResponse response;

        try {

            long startTime = System.currentTimeMillis();

            URL url = new URL(urlString);

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();

            long endTime = System.currentTimeMillis();

            response = new HealthCheckResponse(
                    urlString,
                    responseCode,
                    endTime - startTime,
                    "UP"
            );

        } catch (Exception e) {

            response = new HealthCheckResponse(
                    urlString,
                    0,
                    0,
                    "DOWN"
            );
        }

        metricsClient.sendMetric(response);

        return response;
    }
}