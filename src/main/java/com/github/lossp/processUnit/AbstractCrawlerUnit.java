package com.github.lossp.processUnit;

import com.github.lossp.valueObject.URLNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.*;

public abstract class AbstractCrawlerUnit<T> implements Callable<T> {
    private URLNode page;
    protected static final String FOLLOWER_CLASS_NAME = ".NumberBoard-itemValue";
    protected static final String BASE_URL = "https://www.zhihu.com/";

    public AbstractCrawlerUnit(URLNode page) {
        this.page = page;
    }

    @Override
    public T call() {
        try {
            Document document = Jsoup.connect(page.getUrl()).get();
            Elements elements = document.select(FOLLOWER_CLASS_NAME);
            // there are two elements with the same class name, the last one is what we need, therefore, index = size -1
            Element specificElement = elements.get(elements.size() - 1);
            String followerNumber = specificElement.text();
            return (T) followerNumber;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
