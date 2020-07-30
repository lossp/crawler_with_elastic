package com.github.lossp.factory;

import com.github.lossp.valueObject.URLNode;

import java.util.concurrent.LinkedBlockingQueue;

public class PageLinksPool {
    private LinkedBlockingQueue<URLNode> blockingQueue = new LinkedBlockingQueue<>();
    private static PageLinksPool pageLinksPool;

    public static PageLinksPool getInstance() {
        if (pageLinksPool == null) {
            synchronized (PageLinksPool.class) {
                if (pageLinksPool == null) {
                    pageLinksPool = new PageLinksPool();
                    return pageLinksPool;
                }
            }
        }
        return pageLinksPool;
    }

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
