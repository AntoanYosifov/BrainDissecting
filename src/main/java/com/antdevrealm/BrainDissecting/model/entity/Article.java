package com.antdevrealm.BrainDissecting.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articles")
public class Article extends BaseEntity {
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String abstractText;
    @Column(nullable = false)
    private LocalDate publishedOn;
    @Column(nullable = false)
    private String journal;
    private String volume;
    @Column(nullable = false)
    private String link;

    public String getJournal() {
        return journal;
    }

    public Article setJournal(String journal) {
        this.journal = journal;
        return this;
    }

    public String getVolume() {
        return volume;
    }

    public Article setVolume(String volume) {
        this.volume = volume;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Article setLink(String link) {
        this.link = link;
        return this;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public Article setAuthors(Set<Author> authors) {
        this.authors = authors;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Article setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    @ManyToMany
    @JoinTable(
            name = "article_authors",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;
    // Consider adding image field later
    @ManyToMany
    @JoinTable(
            name = "article_categories",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    public Article() {
        this.authors = new HashSet<>();
        this.categories = new HashSet<>();
    }


    public LocalDate getPublishedOn() {
        return publishedOn;
    }

    public Article setPublishedOn(LocalDate publishedOn) {
        this.publishedOn = publishedOn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public Article setAbstractText(String content) {
        this.abstractText = content;
        return this;
    }


}
