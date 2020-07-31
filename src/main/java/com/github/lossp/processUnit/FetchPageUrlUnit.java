package com.github.lossp.processUnit;

import com.github.lossp.factory.PageLinksPool;
import com.github.lossp.valueObject.URLNode;

public class FetchPageUrlUnit implements Runnable {
    private PageLinksPool pageLinksPool;

    public FetchPageUrlUnit(PageLinksPool pageLinksPool) {
        this.pageLinksPool = pageLinksPool;
    }

    @Override
    public void run() {
        while (!pageLinksPool.isEmpty()) {
            URLNode urlNode = pageLinksPool.poll();
            System.out.println("----------");
            System.out.println(urlNode.getUrl());
        }
    }
}
