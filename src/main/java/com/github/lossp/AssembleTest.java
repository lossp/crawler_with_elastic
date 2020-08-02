package com.github.lossp;

import com.github.lossp.factory.PageLinksPool;
import com.github.lossp.factory.URLNodeByGetMethodFactory;
import com.github.lossp.processUnit.FetchPageUrlUnit;
import com.github.lossp.processUnit.FollowerListCrawlerUnit;
import com.github.lossp.processUnit.FollowerListPageInfoCrawlerUnit;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class AssembleTest {
    private static URLNodeByGetMethodFactory getMethodFactory = new URLNodeByGetMethodFactory();
    private ExecutorService executorService = Executors.newFixedThreadPool(3);
    private static PageLinksPool pageLinksPool = PageLinksPool.getInstance();
    private static final String baseUrl = "https://www.zhihu.com/people/zhang-jia-wei/followers";

    public static void main(String[] args) {
        try {
            AssembleTest assembleTest = new AssembleTest();
            FutureTask<Integer> futureTask = new FutureTask<>(new FollowerListPageInfoCrawlerUnit(getMethodFactory.createInstance("https://www.zhihu.com/people/zhang-jia-wei/followers")));

//            FollowerListCrawlerUnit followerListCrawlerUnit = new FollowerListCrawlerUnit(getMethodFactory.createInstance(""));
            FetchPageUrlUnit fetchPageUrlUnit = new FetchPageUrlUnit(pageLinksPool);

            FollowerListCrawlerUnit followerListCrawlerUnit = new FollowerListCrawlerUnit(pageLinksPool);
            assembleTest.executorService.submit(futureTask);
            Integer result = futureTask.get();
            for (int i = 1; i < result + 1; i++) {
                String url = baseUrl + "?page=" + i;
                pageLinksPool.put(getMethodFactory.createInstance(url));
            }
            assembleTest.executorService.submit(followerListCrawlerUnit);

//            Thread thread = new Thread(fetchPageUrlUnit);
//            thread.start();


            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {

        }
    }
}
