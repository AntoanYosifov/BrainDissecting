package com.antdevrealm.BrainDissecting.init;

import com.antdevrealm.BrainDissecting.model.dto.api.ArticleDTO;
import com.antdevrealm.BrainDissecting.model.entity.Article;
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
        ArticleDTO articleDTO = articleService.fetchArticle();

        articleService.createArticle(articleDTO);
        System.out.println();
    }
}
