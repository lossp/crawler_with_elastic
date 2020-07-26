package com.github.lossp.utils;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public interface HttpRequestMethod {
    public Request getRequestBuilder();

    public Request postRequestBuilder(String url, RequestBody requestBody);

    public Request deleteRequestBuilder(String url, RequestBody requestBody);

    public Request putRequestBuilder(String url, RequestBody requestBody);

    public Request optionsRequestsBuilder(String url);

    public Request traceRequestBuilder(String url);

    public Request headRequestBuilder(String ulr);

}
