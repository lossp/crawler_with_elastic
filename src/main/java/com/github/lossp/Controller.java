package com.github.lossp;

import org.apache.http.HttpEntity;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Controller {

    public static void main(String[] args) throws IOException{
        // CloseableHttpClient和HttpClient???
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.baidu.com");
        try(CloseableHttpResponse response1 = httpClient.execute(httpGet)) {
            System.out.println(response1.getStatusLine());
            HttpEntity httpEntity1 = response1.getEntity();
            System.out.println(EntityUtils.toString(httpEntity1));
        }
    }
}
