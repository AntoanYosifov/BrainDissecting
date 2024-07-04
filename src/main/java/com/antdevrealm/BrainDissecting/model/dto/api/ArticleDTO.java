package com.antdevrealm.BrainDissecting.model.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleDTO {
    private String id;
    @JsonProperty("bibjson")
    private BibJsonDTO bibjson;


    public BibJsonDTO getBibjson() {
        return bibjson;
    }

    public ArticleDTO setBibjson(BibJsonDTO bibjson) {
        this.bibjson = bibjson;
        return this;
    }

    public String getId() {
        return id;
    }

    public ArticleDTO setId(String id) {
        this.id = id;
        return this;
    }
}
