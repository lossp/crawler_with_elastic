package com.github.lossp.factory;

import com.github.lossp.processUnit.CrawlerUnit;

import java.util.ArrayList;

public class CrawlerFactory implements Factory<CrawlerUnit> {
    @Override
    public CrawlerUnit createInstance() {
        return new CrawlerUnit(new ArrayList<>());
    }
}
