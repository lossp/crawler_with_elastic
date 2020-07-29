package com.github.lossp.factory;

import com.github.lossp.processUnit.AbstractCrawlerUnit;
import com.github.lossp.processUnit.PersonalHomePageCrawlerUnit;
import com.github.lossp.valueObject.URLNode;

public class CrawlerFactory implements Factory<AbstractCrawlerUnit> {
    @Override
    public AbstractCrawlerUnit createInstance(String protocol, String url, String method) {
        return new PersonalHomePageCrawlerUnit(new URLNode(protocol, url, method));
    }
}
