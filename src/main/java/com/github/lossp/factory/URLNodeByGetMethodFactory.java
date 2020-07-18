package com.github.lossp.factory;

import com.github.lossp.valueObject.URLNode;

public class URLNodeByGetMethodFactory extends URLFactory<URLNode> {
    private static String METHOD = "GET";
    @Override
    public URLNode createInstance(String url) {
        String protocol = url.split(":")[0];
        URLNode urlNode = new URLNode(protocol, url, METHOD);
        return urlNode;
    }
}
