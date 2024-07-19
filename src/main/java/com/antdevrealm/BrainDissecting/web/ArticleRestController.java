package com.antdevrealm.BrainDissecting.web;

import com.antdevrealm.BrainDissecting.model.dto.ArticleInfoDTO;
import com.antdevrealm.BrainDissecting.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "http://localhost:3000")
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<ArticleInfoDTO>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleInfoDTO> getArticleById(@PathVariable Long id) {
        Optional<ArticleInfoDTO> articleInfoDTO = articleService.findById(id);
        return articleInfoDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // handle getting empty List from your articleService
    @GetMapping("/top")
    public ResponseEntity<List<ArticleInfoDTO>> getTop5Articles() {
        return ResponseEntity.ok(articleService.getTop9Articles());
    }


    // Continue with creating endpoints for Creating And Deleting Articles by ADMIN

}