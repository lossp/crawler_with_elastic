package com.github.lossp.factory;

import com.github.lossp.valueObject.URLNode;

import java.util.concurrent.LinkedBlockingQueue;

public abstract class AbstractLinksPool {
    protected LinkedBlockingQueue<URLNode> blockingQueue = new LinkedBlockingQueue<>();
    protected static LinksPool linksPool;

    public void put(URLNode urlNode) throws InterruptedException {
        this.blockingQueue.put(urlNode);
    }

    public LinkedBlockingQueue getBlockingQueue() {
        return this.blockingQueue;
    }

    public URLNode poll() {
        return this.blockingQueue.poll();
    }

    public boolean isEmpty() {
        return blockingQueue.isEmpty();
    }
}
