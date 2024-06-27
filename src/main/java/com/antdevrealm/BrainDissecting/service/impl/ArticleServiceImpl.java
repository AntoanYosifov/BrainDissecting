package com.antdevrealm.BrainDissecting.service.impl;

import com.antdevrealm.BrainDissecting.model.dto.ArticleInfoDTO;
import com.antdevrealm.BrainDissecting.model.entity.Article;
import com.antdevrealm.BrainDissecting.repository.ArticleRepository;
import com.antdevrealm.BrainDissecting.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ArticleInfoDTO> getAll() {
        return articleRepository.findAll()
                .stream()
                .map(ArticleServiceImpl::mapArticleToDTO)
                .toList();
    }

    @Override
    public Optional<ArticleInfoDTO> findById(Long id) {
        return articleRepository.findById(id).map(ArticleServiceImpl::mapArticleToDTO);
    }

    private static ArticleInfoDTO mapArticleToDTO(Article article){
        return new ArticleInfoDTO()
                .setId(article.getId())
                .setAuthor(article.getAuthor())
                .setContent(article.getContent())
                .setTitle(article.getTitle())
                .setPublishedOn(article.getPublishedOn());
    }


}