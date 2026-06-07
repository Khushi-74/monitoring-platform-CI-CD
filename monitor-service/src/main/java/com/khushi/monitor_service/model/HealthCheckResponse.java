package com.khushi.monitor_service.model;

public class HealthCheckResponse {

    private String url;
    private int responseCode;
    private long responseTime;
    private String status;

    public HealthCheckResponse() {
    }

    public HealthCheckResponse(String url, int responseCode, long responseTime, String status) {
        this.url = url;
        this.responseCode = responseCode;
        this.responseTime = responseTime;
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}