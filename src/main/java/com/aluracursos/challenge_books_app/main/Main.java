package com.aluracursos.challenge_books_app.main;

import com.aluracursos.challenge_books_app.model.Data;
import com.aluracursos.challenge_books_app.service.ApiConsume;
import com.aluracursos.challenge_books_app.service.ConvertData;

public class Main {
    private static final String URI = "https://gutendex.com/books/";

    private final ApiConsume apiConsume = new ApiConsume();
    private ConvertData convertData = new ConvertData();

    public void displayMenu() {

        String json = apiConsume.getData(URI);
        System.out.println(json);
        var data = convertData.getData(json, Data.class);

        System.out.println(data);
    }
}
