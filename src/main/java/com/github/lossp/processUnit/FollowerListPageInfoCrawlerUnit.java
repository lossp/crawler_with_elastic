package com.github.lossp.processUnit;

import com.github.lossp.factory.URLNodeByGetMethodFactory;
import com.github.lossp.valueObject.URLNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FollowerListPageInfoCrawlerUnit extends AbstractCrawlerUnit<Integer> {
    private static final String PAGE_NUMBER_CLASS_NAME = ".Pagination>button";

    public FollowerListPageInfoCrawlerUnit(URLNode page) {
        super(page);
    }

    @Override
    public Integer call() {
        try {
            Document document = Jsoup.connect(page.getUrl()).get();
            Elements elements = document.select(PAGE_NUMBER_CLASS_NAME);
            // the total number of pages is the last second one.
            Element pageElement = elements.get(elements.size() - 2);
            System.out.println("the total number of pages is " + pageElement.text());
            return Integer.valueOf(pageElement.text());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        URLNodeByGetMethodFactory factory = new URLNodeByGetMethodFactory();
        URLNode urlNode = factory.createInstance("https://www.zhihu.com/people/zhang-jia-wei/followers");
        FutureTask<Integer> task = new FutureTask<>(new FollowerListPageInfoCrawlerUnit(urlNode));
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(task);
        executorService.shutdown();
    }


}
