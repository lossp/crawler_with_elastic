package com.github.lossp.factory;

import com.github.lossp.valueObject.URLNode;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinksPool {
    private List<URLNode> urlNodes;
    private LinksPool linksPool;

    public LinksPool() {
        this.urlNodes = new CopyOnWriteArrayList<>();
    }

    public LinksPool getInstance() {
        if (linksPool == null) {
            synchronized (LinksPool.class) {
                if (linksPool == null) {
                    linksPool = new LinksPool();
                }
            }
        }
        return linksPool;
    }

    public List<URLNode> getUrlNodes() { return this.urlNodes; }
}
