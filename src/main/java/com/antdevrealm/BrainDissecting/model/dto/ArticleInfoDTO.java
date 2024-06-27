package com.antdevrealm.BrainDissecting.model.dto;

import java.time.LocalDate;

public class ArticleInfoDTO {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDate publishedOn;

    public ArticleInfoDTO() {
    }

    public Long getId() {
        return id;
    }

    public ArticleInfoDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ArticleInfoDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ArticleInfoDTO setContent(String content) {
        this.content = content;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public ArticleInfoDTO setAuthor(String author) {
        this.author = author;
        return this;
    }

    public LocalDate getPublishedOn() {
        return publishedOn;
    }

    public ArticleInfoDTO setPublishedOn(LocalDate publishedOn) {
        this.publishedOn = publishedOn;
        return this;
    }
}
