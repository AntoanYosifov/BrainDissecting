package com.antdevrealm.BrainDissecting.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "doaj.api")
public class DoajApiConfig {
    private String url;
    private String subject;
    private int pageSize;

    public String getUrl() {
        return url;
    }

    public DoajApiConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public void checkConfiguration(){
        verifyNullOrNotEmpty("url", url);
    }

    private static void verifyNullOrNotEmpty(String name, String value){
        if(value == null || value.isBlank()){
            throw new IllegalArgumentException("Property " + name + " cannot be empty.");
        }
    }

    public String getSubject() {
        return subject;
    }

    public DoajApiConfig setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public DoajApiConfig setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
