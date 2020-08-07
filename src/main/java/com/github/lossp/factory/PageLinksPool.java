package com.github.lossp.factory;

public class PageLinksPool extends AbstractLinksPool implements LinksPool{
    public static LinksPool getInstance() {
        if (linksPool == null) {
            synchronized (PageLinksPool.class) {
                if (linksPool == null) {
                    linksPool = new PageLinksPool();
                }
            }
        }
        return linksPool;
    }
}
