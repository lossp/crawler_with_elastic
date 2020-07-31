package com.github.lossp.factory;

public interface Factory<T> {
    T createInstance(String protocol, String url, String method);
}
