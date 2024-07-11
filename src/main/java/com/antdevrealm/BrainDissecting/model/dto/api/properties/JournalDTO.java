package com.antdevrealm.BrainDissecting.model.dto.api.properties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class JournalDTO {
    private String title;
    private String publisher;
    private String volume;
    private String country;
    private List<String> language;

    public JournalDTO() {
        this.language = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public JournalDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public JournalDTO setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getVolume() {
        return volume;
    }

    public JournalDTO setVolume(String volume) {
        this.volume = volume;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public JournalDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public List<String> getLanguage() {
        return language;
    }

    public JournalDTO setLanguage(List<String> language) {
        this.language = language;
        return this;
    }
}
