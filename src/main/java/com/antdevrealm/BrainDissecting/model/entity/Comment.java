package com.antdevrealm.BrainDissecting.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{
    @ManyToOne(optional = false)
    private User user;
    @ManyToOne(optional = false)
    private Article article;
    @Column(columnDefinition = "TEXT", nullable = false, length = 500)
    private String content;
    @Column(name = "commented_on", nullable = false)
    private LocalDateTime commentedOn;

    public Comment() {
    }

    public User getUser() {
        return user;
    }

    public Comment setUser(User user) {
        this.user = user;
        return this;
    }

    public Article getArticle() {
        return article;
    }

    public Comment setArticle(Article article) {
        this.article = article;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public LocalDateTime getCommentedOn() {
        return commentedOn;
    }

    public Comment setCommentedOn(LocalDateTime commentedOn) {
        this.commentedOn = commentedOn;
        return this;
    }
}
