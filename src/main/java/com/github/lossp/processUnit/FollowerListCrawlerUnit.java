package com.github.lossp.processUnit;

import com.github.lossp.factory.PageLinksPool;
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

/**
 * This class is not working well..
 * Zhihu follower api is not available at the moment (personal use of course)
 * The authentication of this zhihu api is unknown to me.
 * Therefore, only 3 out of 20 users can I get at every single page.
 */
public class FollowerListCrawlerUnit extends AbstractCrawlerUnit<String> {
    private final static String USER_LINK_CLASS_NAME = ".UserLink-link";

    public FollowerListCrawlerUnit(PageLinksPool pageLinksPool) {
        super(pageLinksPool);
    }

    @Override
    public String call() {
        while (!pageLinksPool.isEmpty()) {
            try {
                URLNode urlNode = pageLinksPool.poll();
                Document document = Jsoup.connect(urlNode.getUrl()).get();
                // TODO problem is serious, only three users per page, why?
                Elements elements = document.select(USER_LINK_CLASS_NAME);
                for (Element element:elements) {
                    if (element.hasText()) {
                        System.out.println(element);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
