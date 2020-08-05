package com.github.lossp.processUnit;

import com.github.lossp.constants.CssClassNameSelector;
import com.github.lossp.valueObject.URLNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.Callable;

public class FollowerListPageInfoCrawlerUnit implements Callable<Integer> {
    private final URLNode urlNode;

    public FollowerListPageInfoCrawlerUnit(URLNode urlNode) {
        this.urlNode = urlNode;
    }

    @Override
    public Integer call() {
        try {
            Document document = Jsoup.connect(urlNode.getUrl()).get();
            Elements elements = document.select(CssClassNameSelector.getPageNumberClassName());
            // the total number of pages is the last second one.
            Element pageElement = elements.get(elements.size() - 2);
            System.out.println("the total number of pages is " + pageElement.text());
            return Integer.valueOf(pageElement.text());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
