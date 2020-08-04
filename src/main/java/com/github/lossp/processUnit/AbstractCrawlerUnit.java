package com.github.lossp.processUnit;

import com.github.lossp.factory.PageLinksPool;
import java.util.concurrent.*;

public abstract class AbstractCrawlerUnit<T> implements Callable<T> {
    protected PageLinksPool pageLinksPool;

    public AbstractCrawlerUnit(PageLinksPool pageLinksPool) {
        this.pageLinksPool = pageLinksPool;
    }
}
