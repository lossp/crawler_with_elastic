package com.github.lossp.processUnit;

import com.github.lossp.factory.URLNodeByGetMethodFactory;
import com.github.lossp.utils.NumberParser;
import com.github.lossp.valueObject.URLNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class PersonalHomePageCrawlerUnit extends AbstractCrawlerUnit<Integer> {
    private static final String FOLLOWER_CLASS_NAME = ".NumberBoard-itemValue";
    public PersonalHomePageCrawlerUnit(URLNode page) {
        super(page);
    }
    @Override
    public Integer call() {
        try {
            Document document = Jsoup.connect(page.getUrl()).get();
            Elements elements = document.select(FOLLOWER_CLASS_NAME);
            // there are two elements with the same class name, the last one is what we need, therefore, index = size -1
            Element specificElement = elements.get(elements.size() - 1);
            String followerNumber = specificElement.text();
            // deal with the number format, which number separated by comma, like 2,400
            return NumberParser.parseStringIntoInteger(followerNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            URLNodeByGetMethodFactory factory = new URLNodeByGetMethodFactory();
            URLNode urlNode = factory.createInstance("https://www.zhihu.com/people/zhang-jia-wei");
            FutureTask<Integer> task = new FutureTask<>(new PersonalHomePageCrawlerUnit(urlNode));
            ExecutorService service = Executors.newSingleThreadExecutor();
            service.submit(task);
            System.out.println("thread result = " + task.get());
            service.shutdown();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
