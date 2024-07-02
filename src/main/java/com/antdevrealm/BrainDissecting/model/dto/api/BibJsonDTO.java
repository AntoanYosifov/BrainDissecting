package com.antdevrealm.BrainDissecting.model.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BibJsonDTO {
    private String title;
    private String year;
    private String month;
    private String abstractText;
    private JournalDTO journal;
    private List<AuthorDTO> author;
    private List<String> keywords;
    private List<LinkDTO> link;

    public BibJsonDTO() {
        this.author = new ArrayList<>();
        this.keywords = new ArrayList<>();
        this.link = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public BibJsonDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getYear() {
        return year;
    }

    public BibJsonDTO setYear(String year) {
        this.year = year;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public BibJsonDTO setMonth(String month) {
        this.month = month;
        return this;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public BibJsonDTO setAbstractText(String abstractText) {
        this.abstractText = abstractText;
        return this;
    }

    public JournalDTO getJournal() {
        return journal;
    }

    public BibJsonDTO setJournal(JournalDTO journal) {
        this.journal = journal;
        return this;
    }

    public List<AuthorDTO> getAuthor() {
        return author;
    }

    public BibJsonDTO setAuthor(List<AuthorDTO> author) {
        this.author = author;
        return this;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public BibJsonDTO setKeywords(List<String> keywords) {
        this.keywords = keywords;
        return this;
    }

    public List<LinkDTO> getLink() {
        return link;
    }

    public BibJsonDTO setLink(List<LinkDTO> link) {
        this.link = link;
        return this;
    }
}
