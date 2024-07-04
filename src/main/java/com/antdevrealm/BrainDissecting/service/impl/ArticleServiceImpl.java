package com.antdevrealm.BrainDissecting.service.impl;

import com.antdevrealm.BrainDissecting.config.DoajApiConfig;
import com.antdevrealm.BrainDissecting.model.dto.ArticleInfoDTO;
import com.antdevrealm.BrainDissecting.model.dto.api.ArticleDTO;
import com.antdevrealm.BrainDissecting.repository.ArticleRepository;
import com.antdevrealm.BrainDissecting.service.ArticleService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final RestClient restClient;
    private final ArticleRepository articleRepository;
    private final DoajApiConfig doajApiConfig;

    public ArticleServiceImpl(RestClient restClient,
                              ArticleRepository articleRepository, DoajApiConfig doajApiConfig) {
        this.restClient = restClient;
        this.articleRepository = articleRepository;
        this.doajApiConfig = doajApiConfig;
    }

    @Override
    public List<ArticleInfoDTO> getAll() {
        return null;
    }

    @Override
    public Optional<ArticleInfoDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ArticleDTO fetchArticle() {
        return restClient
                .get()
                .uri(doajApiConfig.getUrl())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ArticleDTO.class);
    }

}