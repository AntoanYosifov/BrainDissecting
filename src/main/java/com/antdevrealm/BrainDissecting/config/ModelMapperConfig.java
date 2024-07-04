package com.antdevrealm.BrainDissecting.config;

import com.antdevrealm.BrainDissecting.model.dto.api.ArticleDTO;
import com.antdevrealm.BrainDissecting.model.dto.api.AuthorDTO;
import com.antdevrealm.BrainDissecting.model.entity.Article;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Collections;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Condition<?, ?> notNull = context -> context.getSource() != null;

        modelMapper.typeMap(ArticleDTO.class, Article.class).addMappings(mapper -> {
            mapper.when(notNull).map(src -> src.getBibjson().getTitle(), Article::setTitle);
            mapper.when(notNull).map(src -> src.getBibjson().getAbstractText(), Article::setAbstractText);
            mapper.map(src -> {
                String year = src.getBibjson().getYear();
                String month = src.getBibjson().getMonth();
                return (year != null && month != null) ? LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1) : null;
            }, Article::setPublicationDate);
            mapper.when(notNull).map(src -> src.getBibjson().getJournal().getTitle(), Article::setJournalTitle);
            mapper.when(notNull).map(src -> src.getBibjson().getJournal().getPublisher(), Article::setJournalPublisher);
            mapper.when(notNull).map(src -> src.getBibjson().getJournal().getVolume(), Article::setJournalVolume);
            mapper.when(notNull).map(src -> {
                if (src.getBibjson().getAuthor() != null) {
                    return src.getBibjson().getAuthor().stream().map(AuthorDTO::getName).collect(Collectors.toList());
                } else {
                    return Collections.emptyList();
                }
            }, Article::setAuthors);
            mapper.when(notNull).map(src -> src.getBibjson().getKeywords(), Article::setKeywords);
            mapper.when(notNull).map(src -> src.getBibjson().getKeywords(), Article::setKeywords);
            mapper.when(notNull).map(src -> {
                if (src.getBibjson().getLink() != null && !src.getBibjson().getLink().isEmpty()) {
                    return src.getBibjson().getLink().get(0).getUrl();
                } else {
                    return null;
                }
            }, Article::setLink);
        });

        return modelMapper;
    }
}
