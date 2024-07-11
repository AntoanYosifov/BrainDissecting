package com.antdevrealm.BrainDissecting.service.impl;

import com.antdevrealm.BrainDissecting.config.DoajApiConfig;
import com.antdevrealm.BrainDissecting.model.dto.ArticleInfoDTO;
import com.antdevrealm.BrainDissecting.model.dto.api.ArticleDTO;
import com.antdevrealm.BrainDissecting.model.dto.api.AuthorDTO;
import com.antdevrealm.BrainDissecting.model.dto.api.BibJsonDTO;
import com.antdevrealm.BrainDissecting.model.entity.Article;
import com.antdevrealm.BrainDissecting.repository.ArticleRepository;
import com.antdevrealm.BrainDissecting.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final RestClient restClient;
    private final ArticleRepository articleRepository;
    private final DoajApiConfig doajApiConfig;
    private final ModelMapper modelMapper;


    public ArticleServiceImpl(
            RestClient restClient,
            ArticleRepository articleRepository,
            DoajApiConfig doajApiConfig, ModelMapper modelMapper) {

        this.restClient = restClient;
        this.articleRepository = articleRepository;
        this.doajApiConfig = doajApiConfig;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ArticleInfoDTO> getAll() {
        return null;
    }

    @Override
    public Optional<ArticleInfoDTO> findById(Long id) {
        Optional<Article> byId = articleRepository.findById(id);

        return byId.map(article -> modelMapper.map(article, ArticleInfoDTO.class));

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

    private Article mapToArticle(ArticleDTO articleDTO) {
        BibJsonDTO bibJson = articleDTO.getBibJson();

        Article article = new Article();

        return article.setTitle(bibJson.getTitle())
                .setAbstractText(bibJson.getAbstractText())
                .setPublicationDate(LocalDate.of(Integer.parseInt(bibJson.getYear()),
                        Integer.parseInt(bibJson.getMonth()), 1))
                .setJournalTitle(bibJson.getJournal().getTitle())
                .setJournalPublisher(bibJson.getJournal().getPublisher())
                .setJournalVolume(bibJson.getJournal().getVolume())
                .setAuthors(bibJson.getAuthor().stream().map(AuthorDTO::getName)
                        .toList())
                .setKeywords(bibJson.getKeywords())
                .setLink(bibJson.getLink().get(0).getUrl());


    }

    @Override
    public void createArticle(ArticleDTO articleDTO) {
        this.articleRepository.save(mapToArticle(articleDTO));
    }

}