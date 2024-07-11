package com.antdevrealm.BrainDissecting.init;

import com.antdevrealm.BrainDissecting.model.dto.api.MultipleArticlesResponseDTO;
import com.antdevrealm.BrainDissecting.service.ArticleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitArticles implements CommandLineRunner {
    private final ArticleService articleService;

    public InitArticles(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public void run(String... args) throws Exception {
        MultipleArticlesResponseDTO multipleArticlesResponseDTO = articleService.fetchMultipleArticles();

//        Optional<ArticleInfoDTO> articleInfoDTO = articleService.findById(1L);
       System.out.println();
    }
}
