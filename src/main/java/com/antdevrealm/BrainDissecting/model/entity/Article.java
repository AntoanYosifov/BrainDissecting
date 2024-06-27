package com.antdevrealm.BrainDissecting.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "articles")
public class Article extends BaseEntity{
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(nullable = false)
    private String author;
    // Consider adding image field later
    @ManyToOne(optional = false)
    private Category category;
    @Column(nullable = false)
    private LocalDate publishedOn;

    public Article() {
    }


    public String getAuthor() {
        return author;
    }

    public Article setAuthor(String author) {
        this.author = author;
        return this;
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

    public String getContent() {
        return content;
    }

    public Article setContent(String content) {
        this.content = content;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Article setCategory(Category category) {
        this.category = category;
        return this;
    }
}
