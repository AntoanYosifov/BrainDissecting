package com.antdevrealm.BrainDissecting.model.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkDTO {
    private String type;
    private String url;

    public String getType() {
        return type;
    }

    public LinkDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public LinkDTO setUrl(String url) {
        this.url = url;
        return this;
    }
}
