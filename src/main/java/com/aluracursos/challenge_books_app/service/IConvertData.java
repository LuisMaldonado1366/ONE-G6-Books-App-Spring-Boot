package com.aluracursos.challenge_books_app.service;

public interface IConvertData {
    <T> T getData(String json, Class<T> targetClass);
}
