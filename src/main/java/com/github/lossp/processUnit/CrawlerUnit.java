package com.github.lossp.processUnit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.lossp.factory.URLFactory;
import com.github.lossp.factory.URLNodeByGetMethodFactory;
import com.github.lossp.valueObject.URLNode;
import okhttp3.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CrawlerUnit<T> implements Callable<T> {
    private List<URLNode> urls;
    private OkHttpClient okHttpClient;

    public CrawlerUnit(List<URLNode> urls) {
        this.urls = urls;
    }

    public CrawlerUnit(URLNode url) {
        this(Arrays.asList(url));
    }

    @Override
    public T call() {
        try {
            final Request request = okHttpClientBuilder("https://www.zhihu.com/api/v4/members/excited-vczh/followers");
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            String result = response.body().string();
            JSONObject jsonObject = JSON.parseObject(result);
            System.out.println(jsonObject);
            String paging = jsonObject.getString("paging");
            String totals = JSON.parseObject(paging).getString("totals");
            return (T) totals;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private Request okHttpClientBuilder(String url) {
        this.okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(url).get().build();
        return request;
    }

    public static void main(String[] args) {
        try {
            URLFactory<URLNode> factory = new URLNodeByGetMethodFactory();
            URLNode urlNode = factory.createInstance("https://www.zhihu.com/api/v4/members/excited-vczh/followers");
            FutureTask<Integer> futureTask = new FutureTask(new CrawlerUnit(urlNode));
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.submit(futureTask);
            System.out.println("thread" + futureTask.get());
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
