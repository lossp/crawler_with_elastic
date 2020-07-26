package com.github.lossp.processUnit;

import com.github.lossp.utils.HttpRequestBuilder;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.*;

public class ZhihuFollowerCrawlerUnit<T> implements Callable<T> {

    private final static String FOLLOWER_LIST_API = "https://www.zhihu.com/api/v4/members/excited-vczh/followers";
    private final static String LIMIT = "limit";
    private final static String OFFSET = "offset";
    private final int limit;
    private final int offset;
    private final String taskUrl;
    private HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
    private final OkHttpClient okHttpClient;


    public ZhihuFollowerCrawlerUnit(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
        this.okHttpClient = new OkHttpClient();
        // TODO use annotation to improve
        this.taskUrl = FOLLOWER_LIST_API + "?" + LIMIT + "=" + limit + "&" + OFFSET + "=" + offset;
    }

    @Override
    public T call() {
        try {
            final Request request = httpRequestBuilder.getRequestBuilder(this.taskUrl);
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            String body = response.body().string();
            System.out.println(body);
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        ZhihuFollowerCrawlerUnit zhihuFollowerCrawlerUnit = new ZhihuFollowerCrawlerUnit(20, 10);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask future = new FutureTask(zhihuFollowerCrawlerUnit);
        executorService.submit(future);
    }
}
