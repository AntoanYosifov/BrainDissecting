package com.antdevrealm.BrainDissecting.model.dto.api;

import com.antdevrealm.BrainDissecting.model.dto.api.properties.BibJsonDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleDTO {
    @JsonProperty("bibjson")
    private BibJsonDTO bibjson;


    public BibJsonDTO getBibJson() {
        return bibjson;
    }

    public ArticleDTO setBibJson(BibJsonDTO bibjson) {
        this.bibjson = bibjson;
        return this;
    }


}
