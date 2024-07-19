package com.antdevrealm.BrainDissecting.service;

import com.antdevrealm.BrainDissecting.model.dto.ArticleInfoDTO;
import com.antdevrealm.BrainDissecting.model.dto.api.MultipleArticlesResponseDTO;
import com.antdevrealm.BrainDissecting.model.dto.api.ArticleDTO;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<ArticleInfoDTO> getAll();

    List<ArticleInfoDTO> getTop9Articles();

    Optional<ArticleInfoDTO> findById(Long id);

    ArticleDTO fetchArticle();

    void createArticle(ArticleDTO articleDTO);

    MultipleArticlesResponseDTO fetchMultipleArticles();

    void createMultipleArticles(MultipleArticlesResponseDTO multipleArticlesResponseDTO);
}