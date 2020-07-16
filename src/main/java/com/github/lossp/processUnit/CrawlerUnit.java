package com.github.lossp.processUnit;

import org.apache.http.client.methods.HttpGet;

import java.util.List;

public class CrawlerUnit implements Runnable {
    private List<String> urls;

    public CrawlerUnit(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public void run() {

    }
}
