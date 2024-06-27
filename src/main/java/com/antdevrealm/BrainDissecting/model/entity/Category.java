package com.antdevrealm.BrainDissecting.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    // Consider making the name an Enum and unique
    private String name;
    // Consider adding description field later
    @OneToMany(mappedBy = "category")
    private Set<Article> articles;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    // Consider making the return method immutable and adding a methods to add and remove articles

    public Set<Article> getArticles() {
        return articles;
    }

    public Category setArticles(Set<Article> articles) {
        this.articles = articles;
        return this;
    }
}
