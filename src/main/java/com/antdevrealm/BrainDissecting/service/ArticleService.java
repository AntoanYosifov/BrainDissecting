package com.antdevrealm.BrainDissecting.service;

import com.antdevrealm.BrainDissecting.model.dto.ArticleInfoDTO;
import com.antdevrealm.BrainDissecting.model.dto.api.ArticleDTO;
import com.antdevrealm.BrainDissecting.model.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<ArticleInfoDTO> getAll();

    Optional<ArticleInfoDTO> findById(Long id);

    ArticleDTO fetchArticle();

    void createArticle(ArticleDTO articleDTO);
}