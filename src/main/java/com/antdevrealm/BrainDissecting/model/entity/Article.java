package com.antdevrealm.BrainDissecting.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "articles")
public class Article extends BaseEntity {
    @Column(nullable = false)
    private String title;
    @Column(name = "abstract_text",nullable = false, columnDefinition = "TEXT")
    private String abstractText;
    @Column(name = "publication_date",nullable = false)
    private LocalDate publicationDate;
    @Column(name = "journal_title", nullable = false)
    public String journalTitle;
    @Column(name = "journal_publisher", nullable = false)
    private String journalPublisher;
    @Column(name = "journal_volume", nullable = false)
    private String journalVolume;
    @ElementCollection
    private List<String> authors;
    @ElementCollection
    private List<String> keywords;
    @Column(nullable = false)
    private String link;
    @ManyToMany
    @JoinTable(name = "articles_categories",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    public Article() {
        this.authors = new ArrayList<>();
        this.keywords = new ArrayList<>();
        this.categories = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String text) {
        this.title = text;
        return this;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public Article setAbstractText(String abstractText) {
        this.abstractText = abstractText;
        return this;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public Article setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public Article setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
        return this;
    }

    public String getJournalPublisher() {
        return journalPublisher;
    }

    public Article setJournalPublisher(String journalPublisher) {
        this.journalPublisher = journalPublisher;
        return this;
    }

    public String getJournalVolume() {
        return journalVolume;
    }

    public Article setJournalVolume(String journalVolume) {
        this.journalVolume = journalVolume;
        return this;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public Article setAuthors(List<String> authors) {
        this.authors = authors;
        return this;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public Article setKeywords(List<String> keywords) {
        this.keywords = keywords;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Article setLink(String link) {
        this.link = link;
        return this;
    }
}
