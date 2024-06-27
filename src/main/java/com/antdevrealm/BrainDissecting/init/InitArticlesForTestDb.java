package com.antdevrealm.BrainDissecting.init;

import com.antdevrealm.BrainDissecting.model.entity.Article;
import com.antdevrealm.BrainDissecting.model.entity.Category;
import com.antdevrealm.BrainDissecting.repository.ArticleRepository;
import com.antdevrealm.BrainDissecting.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Component
public class InitArticlesForTestDb implements CommandLineRunner {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    public InitArticlesForTestDb(ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = articleRepository.count();


        if (count > 0) {
            return;
        }

        Article article1 = new Article()
                .setTitle("Article 1")
                .setContent("Content 1")
                .setAuthor("Author 1")
                .setCategory(categoryRepository.save(new Category().setName("category 1").setArticles(new HashSet<>())))
                .setPublishedOn(LocalDate.now());

        Article article2 = new Article()
                .setTitle("Article 2")
                .setContent("Content 2")
                .setAuthor("Author 2")
                .setCategory(categoryRepository.save(new Category().setName("category 2").setArticles(new HashSet<>())))
                .setPublishedOn(LocalDate.now());

        Article article3 = new Article()
                .setTitle("Article 3")
                .setContent("Content 3")
                .setAuthor("Author 3")
                .setCategory(categoryRepository.save(new Category().setName("category 3").setArticles(new HashSet<>())))
                .setPublishedOn(LocalDate.now());

        List<Article> dummyArticles = List.of(article1, article2, article3);

        articleRepository.saveAll(dummyArticles);

    }
}