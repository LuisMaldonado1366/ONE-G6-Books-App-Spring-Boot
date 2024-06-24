package com.aluracursos.challenge_books_app.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Data(
        @JsonAlias("results") List<BookData> booksResults
) {
}
