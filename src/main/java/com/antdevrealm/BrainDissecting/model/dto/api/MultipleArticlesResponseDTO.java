package com.antdevrealm.BrainDissecting.model.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MultipleArticlesResponseDTO {
    private List<ArticleDTO> results;

    public List<ArticleDTO> getResults() {
        return results;
    }

    public MultipleArticlesResponseDTO setResults(List<ArticleDTO> results) {
        this.results = results;
        return this;
    }
}
