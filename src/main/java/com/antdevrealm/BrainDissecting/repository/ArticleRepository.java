package com.antdevrealm.BrainDissecting.repository;

import com.antdevrealm.BrainDissecting.model.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
