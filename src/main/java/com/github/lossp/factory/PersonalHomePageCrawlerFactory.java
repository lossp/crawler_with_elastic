package com.github.lossp.factory;

import com.github.lossp.processUnit.PersonalHomePageCrawlerUnit;
import com.github.lossp.valueObject.URLNode;

public class PersonalHomePageCrawlerFactory implements Factory<PersonalHomePageCrawlerUnit> {
    @Override
    public PersonalHomePageCrawlerUnit createInstance(String protocol, String url, String method) {
        return new PersonalHomePageCrawlerUnit(new URLNode(protocol, url, method));
    }
}
