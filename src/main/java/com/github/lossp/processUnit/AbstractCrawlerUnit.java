package com.github.lossp.processUnit;

import com.github.lossp.factory.LinksPool;
import java.util.concurrent.*;

public abstract class AbstractCrawlerUnit<T> implements Callable<T> {
    protected LinksPool pageLinksPool;

    public AbstractCrawlerUnit(LinksPool pageLinksPool) {
        this.pageLinksPool = pageLinksPool;
    }
}
