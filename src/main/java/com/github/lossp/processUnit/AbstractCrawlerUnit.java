package com.github.lossp.processUnit;

import com.github.lossp.valueObject.URLNode;
import java.util.concurrent.*;

public abstract class AbstractCrawlerUnit<T> implements Callable<T> {
    protected URLNode page;

    public AbstractCrawlerUnit(URLNode page) {
        this.page = page;
    }
}
