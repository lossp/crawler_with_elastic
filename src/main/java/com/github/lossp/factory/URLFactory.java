package com.github.lossp.factory;

public abstract class URLFactory<T> {
    public abstract T createInstance(String url);
}
