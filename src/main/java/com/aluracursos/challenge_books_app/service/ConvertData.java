package com.aluracursos.challenge_books_app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ObjectInput;

public class ConvertData implements IConvertData {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> targetClass) {

        try {
            return mapper.readValue(json, targetClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
