package com.khushi.metrics_service.model;

public class MetricsSummary {

    private int totalChecks;
    private int successChecks;
    private int failedChecks;
    private double averageResponseTime;

    public MetricsSummary() {
    }

    public MetricsSummary(int totalChecks, int successChecks, int failedChecks, double averageResponseTime) {
        this.totalChecks = totalChecks;
        this.successChecks = successChecks;
        this.failedChecks = failedChecks;
        this.averageResponseTime = averageResponseTime;
    }

    public int getTotalChecks() {
        return totalChecks;
    }

    public void setTotalChecks(int totalChecks) {
        this.totalChecks = totalChecks;
    }

    public int getSuccessChecks() {
        return successChecks;
    }

    public void setSuccessChecks(int successChecks) {
        this.successChecks = successChecks;
    }

    public int getFailedChecks() {
        return failedChecks;
    }

    public void setFailedChecks(int failedChecks) {
        this.failedChecks = failedChecks;
    }

    public double getAverageResponseTime() {
        return averageResponseTime;
    }

    public void setAverageResponseTime(double averageResponseTime) {
        this.averageResponseTime = averageResponseTime;
    }
}