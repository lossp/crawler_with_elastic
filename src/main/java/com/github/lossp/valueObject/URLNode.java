package com.github.lossp.valueObject;

import java.util.Date;

public class URLNode {
    // 代表地址
    private String url;
    // 表示标题
    private String header;
    // 表示协议
    private String protocol;

    private long date;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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
