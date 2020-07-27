package com.github.lossp.utils;

import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpRequestBuilder implements HttpRequestMethod{
    public Request getRequestBuilder(String url) {
        return new Request.Builder().url(url).get().build();
    }

    @Override
    public Request getRequestBuilder() {
        return null;
    }

    @Override
    public Request postRequestBuilder(String url, RequestBody requestBody) {
        return null;
    }

    @Override
    public Request deleteRequestBuilder(String url, RequestBody requestBody) {
        return null;
    }

    @Override
    public Request putRequestBuilder(String url, RequestBody requestBody) {
        return null;
    }

    @Override
    public Request optionsRequestsBuilder(String url) {
        return null;
    }

    @Override
    public Request traceRequestBuilder(String url) {
        return null;
    }

    @Override
    public Request headRequestBuilder(String ulr) {
        return null;
    }
}
