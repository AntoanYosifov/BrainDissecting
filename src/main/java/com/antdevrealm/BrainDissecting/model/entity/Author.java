package com.antdevrealm.BrainDissecting.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity{
    @Column(nullable = false)
    private String name;
    private String affiliation;
    @ManyToMany(mappedBy = "authors")
    private Set<Article> articles;

    public Author() {
        this.articles = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public Author setAffiliation(String affiliation) {
        this.affiliation = affiliation;
        return this;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public Author setArticles(Set<Article> articles) {
        this.articles = articles;
        return this;
    }
}
