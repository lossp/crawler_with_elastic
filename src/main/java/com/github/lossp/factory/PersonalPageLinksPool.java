package com.github.lossp.factory;

public class PersonalPageLinksPool extends AbstractLinksPool implements LinksPool {
    public static LinksPool getInstance() {
        if (linksPool == null) {
            synchronized (PersonalPageLinksPool.class) {
                if (linksPool == null) {
                    linksPool = new PersonalPageLinksPool();
                }
            }
        }
        return linksPool;
    }
}
