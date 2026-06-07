package com.khushi.monitor_service.controller;

import com.khushi.monitor_service.model.HealthCheckResponse;
import com.khushi.monitor_service.model.UrlCheckRequest;
import com.khushi.monitor_service.service.MonitorService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonitorController {

    private final MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @PostMapping("/check")
    public HealthCheckResponse checkUrl(
            @RequestBody UrlCheckRequest request) {

        return monitorService.checkUrl(request.getUrl());
    }
}