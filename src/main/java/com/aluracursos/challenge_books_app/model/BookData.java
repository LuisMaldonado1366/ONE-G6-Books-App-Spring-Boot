package com.aluracursos.challenge_books_app.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<AuthorData> author,
        @JsonAlias("languages") List<String>  languages,
        @JsonAlias("download_count") Double downloads
) {
}
