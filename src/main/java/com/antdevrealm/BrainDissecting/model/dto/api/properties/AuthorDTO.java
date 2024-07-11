package com.antdevrealm.BrainDissecting.model.dto.api.properties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorDTO {
    private String name;
    private String affiliation;

    public String getName() {
        return name;
    }

    public AuthorDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public AuthorDTO setAffiliation(String affiliation) {
        this.affiliation = affiliation;
        return this;
    }
}
