package com.antdevrealm.BrainDissecting.model.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleDTO {
    private String id;
    private BibJsonDTO bibJson;

    public String getId() {
        return id;
    }

    public ArticleDTO setId(String id) {
        this.id = id;
        return this;
    }

    public BibJsonDTO getBibJson() {
        return bibJson;
    }

    public ArticleDTO setBibJson(BibJsonDTO bibJson) {
        this.bibJson = bibJson;
        return this;
    }
}
