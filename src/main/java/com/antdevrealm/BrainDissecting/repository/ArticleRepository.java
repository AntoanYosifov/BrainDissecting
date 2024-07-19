package com.antdevrealm.BrainDissecting.repository;

import com.antdevrealm.BrainDissecting.model.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT * from articles LIMIT 9", nativeQuery = true)
    List<Article> findTop9Articles();
}
