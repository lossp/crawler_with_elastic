package com.github.lossp.processUnit;

import java.util.concurrent.Callable;

public class ZhihuFollowerCrawlerUnit<T> implements Callable<T> {

    private final static String FOLLOWER_LIST_API = "https://www.zhihu.com/api/v4/members/excited-vczh/followers?limit=10&offset=10";
    private int limit;
    private int offset;
    @Override
    public T call() {
        return null;
    }
}
