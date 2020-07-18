package com.github.lossp.processUnit;

import com.github.lossp.factory.URLFactory;
import com.github.lossp.factory.URLNodeByGetMethodFactory;
import com.github.lossp.valueObject.URLNode;
import okhttp3.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CrawlerUnit implements Runnable {
    private List<URLNode> urls;
    private OkHttpClient okHttpClient;

    public CrawlerUnit(List<URLNode> urls) {
        this.urls = urls;
    }

    public CrawlerUnit(URLNode url) {
        this(Arrays.asList(url));
    }

    @Override
    public void run() {
        try {
            final Request request = okHttpClientBuilder("https://www.zhihu.com/api/v4/members/excited-vczh/followers");
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();

            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Request okHttpClientBuilder(String url) {
        this.okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(url).get().build();
        return request;
    }

    public static void main(String[] args) {
        URLFactory<URLNode> factory = new URLNodeByGetMethodFactory();
        URLNode urlNode = factory.createInstance("https://www.zhihu.com/api/v4/members/excited-vczh/followers");
        Thread thread = new Thread(new CrawlerUnit(urlNode));
        thread.start();
    }
}
