package com.github.lossp.processUnit;

import com.github.lossp.constants.CssClassNameSelector;
import com.github.lossp.factory.LinksPool;
import com.github.lossp.factory.PageLinksPool;
import com.github.lossp.valueObject.URLNode;
import com.github.lossp.valueObject.ZhihuUser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FetchFollowerPageInfoUnit extends AbstractCrawlerUnit<ZhihuUser> {
    private static String userPageInfoClassName = CssClassNameSelector.getUserPageProfile();

    public FetchFollowerPageInfoUnit(LinksPool linksPool) {
        super(linksPool);
    }

    @Override
    public ZhihuUser call() {
        while (!pageLinksPool.isEmpty()) {
            try {
                URLNode urlNode = pageLinksPool.poll();
                System.out.println("===========" + urlNode.getUrl());
                Document document = Jsoup.connect(urlNode.getUrl()).get();
                // TODO still, information lost 
                Elements elements = document.select(userPageInfoClassName);
                System.out.println(document);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception{
        LinksPool linksPool = PageLinksPool.getInstance();
        linksPool.put(new URLNode("https", "https://www.zhihu.com/people/tian-yang-yu-14", "GET"));
        FetchFollowerPageInfoUnit fetchFollowerPageInfoUnit = new FetchFollowerPageInfoUnit(linksPool);
        ExecutorService executors = Executors.newFixedThreadPool(1);
        executors.submit(fetchFollowerPageInfoUnit);

    }
}
