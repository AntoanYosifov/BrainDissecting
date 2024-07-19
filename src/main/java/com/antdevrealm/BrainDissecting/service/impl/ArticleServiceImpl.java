package com.antdevrealm.BrainDissecting.service.impl;

import com.antdevrealm.BrainDissecting.config.DoajApiConfig;
import com.antdevrealm.BrainDissecting.model.dto.ArticleInfoDTO;
import com.antdevrealm.BrainDissecting.model.dto.api.MultipleArticlesResponseDTO;
import com.antdevrealm.BrainDissecting.model.dto.api.ArticleDTO;
import com.antdevrealm.BrainDissecting.model.dto.api.properties.AuthorDTO;
import com.antdevrealm.BrainDissecting.model.dto.api.properties.BibJsonDTO;
import com.antdevrealm.BrainDissecting.model.entity.Article;
import com.antdevrealm.BrainDissecting.repository.ArticleRepository;
import com.antdevrealm.BrainDissecting.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public List<ArticleInfoDTO> getTop9Articles() {
        List<Article> top5Articles = this.articleRepository.findTop9Articles();

        if (top5Articles.isEmpty()) {
            return new ArrayList<>();
        }

        return top5Articles.stream().map(a -> modelMapper.map(a, ArticleInfoDTO.class)).toList();

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

    @Override
    public MultipleArticlesResponseDTO fetchMultipleArticles() {
        return restClient
                .get()
                .uri(doajApiConfig.getUrl(), doajApiConfig.getSubject(), doajApiConfig.getPageSize())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(MultipleArticlesResponseDTO.class);
    }

    @Override
    public void createArticle(ArticleDTO articleDTO) {
        this.articleRepository.save(mapToArticle(articleDTO));
    }

    @Override
    public void createMultipleArticles(MultipleArticlesResponseDTO multipleArticlesResponseDTO) {
        // Rename the method later when you add update logic.

        List<Article> articles = multipleArticlesResponseDTO.getResults().stream()
                .map(this::mapToArticle).toList();

        this.articleRepository.saveAll(articles);
    }


    private Article mapToArticle(ArticleDTO articleDTO) {
        BibJsonDTO bibJson = articleDTO.getBibJson();

        Article article = new Article();

        LocalDate publicationDate = getPublicationDate(bibJson);
        String abstractText = getAbstractText(bibJson);

        return article.setTitle(bibJson.getTitle())
                .setAbstractText(abstractText)
                .setPublicationDate(publicationDate)
                .setJournalTitle(bibJson.getJournal().getTitle())
                .setJournalPublisher(bibJson.getJournal().getPublisher())
                .setJournalVolume(bibJson.getJournal().getVolume())
                .setAuthors(bibJson.getAuthor().stream().map(AuthorDTO::getName)
                        .toList())
                .setKeywords(bibJson.getKeywords())
                .setLink(bibJson.getLink().get(0).getUrl());
    }

    private static LocalDate getPublicationDate(BibJsonDTO bibJson) {
        LocalDate publicationDate = null;

        if (Integer.parseInt(bibJson.getMonth()) > 0 && Integer.parseInt(bibJson.getMonth()) < 13) {
            publicationDate = LocalDate.of(Integer.parseInt(bibJson.getYear()),
                    Integer.parseInt(bibJson.getMonth()), 1);
        }
        return publicationDate;
    }

    // Consider making abstractText nullable and handling its potential absence on the front-end
    private static String getAbstractText(BibJsonDTO bibJsonDTO) {

        if (bibJsonDTO.getAbstractText() != null) {
            return bibJsonDTO.getAbstractText();
        }

        return "abstract text is not available for this article";
    }

}