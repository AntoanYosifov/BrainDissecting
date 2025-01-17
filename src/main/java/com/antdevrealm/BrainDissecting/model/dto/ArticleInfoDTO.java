package com.antdevrealm.BrainDissecting.model.dto;


public class ArticleInfoDTO {
    private Long id;
    private String title;
    private String abstractText;
    private String journalTitle;
    private String link;

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

    public String getAbstractText() {
        return abstractText;
    }

    public ArticleInfoDTO setAbstractText(String abstractText) {
        this.abstractText = abstractText;
        return this;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public ArticleInfoDTO setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
        return this;
    }

    public String getLink() {
        return link;
    }

    public ArticleInfoDTO setLink(String link) {
        this.link = link;
        return this;
    }
}
