package com.github.lossp.processUnit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Callable;

public class ZhihuFollowerCrawlerUnit<T> implements Callable<T> {

    private final static String FOLLOWER_LIST_API = "https://www.zhihu.com/api/v4/members/excited-vczh/followers";
    private final static String LIMIT = "limit";
    private final static String OFFSET = "offset";
    private final int limit;
    private final int offset;
    private final String taskUrl;


    public ZhihuFollowerCrawlerUnit(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
        // TODO use annotation to improve
        this.taskUrl = FOLLOWER_LIST_API + "?" + LIMIT + "=" + limit + "&" + OFFSET + "=" + offset;
    }


    @Override
    public T call() {
        return null;
    }
}
