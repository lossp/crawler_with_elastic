package com.github.lossp.processUnit;

import com.github.lossp.factory.URLNodeByGetMethodFactory;
import com.github.lossp.valueObject.URLNode;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class PersonalHomePageCrawlerUnit extends AbstractCrawlerUnit<Integer> {
    public PersonalHomePageCrawlerUnit(URLNode page) {
        super(page);
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
