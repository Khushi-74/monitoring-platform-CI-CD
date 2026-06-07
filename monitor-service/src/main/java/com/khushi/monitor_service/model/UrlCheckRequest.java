package com.khushi.monitor_service.model;

public class UrlCheckRequest {

    private String url;

    public UrlCheckRequest() {
    }

    public UrlCheckRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}