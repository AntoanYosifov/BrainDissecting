package com.antdevrealm.BrainDissecting.service;

import com.antdevrealm.BrainDissecting.model.dto.ArticleInfoDTO;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<ArticleInfoDTO> getAll();

    Optional<ArticleInfoDTO> findById(Long id);
}