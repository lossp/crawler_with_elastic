package com.github.lossp.valueObject;

import java.util.Date;

public class URLNode {
    // 代表地址
    private String url;
    // 表示协议
    private String protocol;
    // 表示请求方式
    private String method;

    public URLNode(String protocol, String url, String method) {
        this.protocol = protocol;
        this.url = url;
        this.method = method;

    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    private long date;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
