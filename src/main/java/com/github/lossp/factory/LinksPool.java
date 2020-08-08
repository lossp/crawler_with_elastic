package com.github.lossp.factory;

import com.github.lossp.valueObject.URLNode;

import java.util.concurrent.LinkedBlockingQueue;

public interface LinksPool {
    public void put(URLNode urlNode) throws InterruptedException;

    public LinkedBlockingQueue getBlockingQueue();

    public URLNode poll();

    public boolean isEmpty();
}
