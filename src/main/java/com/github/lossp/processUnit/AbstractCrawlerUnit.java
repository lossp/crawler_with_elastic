package com.github.lossp.processUnit;

import com.github.lossp.valueObject.URLNode;
import java.util.concurrent.*;

public abstract class AbstractCrawlerUnit<T> implements Callable<T> {
    protected URLNode page;
    protected static final String FOLLOWER_CLASS_NAME = ".NumberBoard-itemValue";
    protected static final String BASE_URL = "https://www.zhihu.com/";

    public AbstractCrawlerUnit(URLNode page) {
        this.page = page;
    }
}
