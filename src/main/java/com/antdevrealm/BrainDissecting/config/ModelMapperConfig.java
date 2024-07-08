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
            mapper.when(notNull).map(src -> src.getBibJson().getTitle(), Article::setTitle);
            mapper.when(notNull).map(src -> src.getBibJson().getAbstractText(), Article::setAbstractText);
            mapper.map(src -> {
                String year = src.getBibJson().getYear();
                String month = src.getBibJson().getMonth();
                return (year != null && month != null) ? LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1) : null;
            }, Article::setPublicationDate);
            mapper.when(notNull).map(src -> src.getBibJson().getJournal().getTitle(), Article::setJournalTitle);
            mapper.when(notNull).map(src -> src.getBibJson().getJournal().getPublisher(), Article::setJournalPublisher);
            mapper.when(notNull).map(src -> src.getBibJson().getJournal().getVolume(), Article::setJournalVolume);
            mapper.when(notNull).map(src -> {
                if (src.getBibJson().getAuthor() != null) {
                    return src.getBibJson().getAuthor().stream().map(AuthorDTO::getName).collect(Collectors.toList());
                } else {
                    return Collections.emptyList();
                }
            }, Article::setAuthors);
            mapper.when(notNull).map(src -> src.getBibJson().getKeywords(), Article::setKeywords);
            mapper.when(notNull).map(src -> src.getBibJson().getKeywords(), Article::setKeywords);
            mapper.when(notNull).map(src -> {
                if (src.getBibJson().getLink() != null && !src.getBibJson().getLink().isEmpty()) {
                    return src.getBibJson().getLink().get(0).getUrl();
                } else {
                    return null;
                }
            }, Article::setLink);
        });

        return modelMapper;
    }
}
