package com.aluracursos.challenge_books_app.main;

import com.aluracursos.challenge_books_app.model.BookData;
import com.aluracursos.challenge_books_app.model.Data;
import com.aluracursos.challenge_books_app.service.ApiConsume;
import com.aluracursos.challenge_books_app.service.ConvertData;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final String URI = "https://gutendex.com/books/";

    private final ApiConsume apiConsume = new ApiConsume();
    private final ConvertData convertData = new ConvertData();
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {

        String json = apiConsume.getData(URI);
        System.out.println(json);
        var data = convertData.getData(json, Data.class);
        System.out.println(data);

        // Top 10 downloaded books.
        System.out.println("Top 10 downloaded books.");
        data.booksResults().stream()
                .sorted(Comparator.comparing(BookData::downloads).reversed())
                .limit(10)
                .map(book -> book.title().toUpperCase())
                .forEach(System.out::println);

        // Look for a specific book coincidence.
        System.out.println("Enter the book name to search for: ");
        String userBook = scanner.nextLine();
        String jsonUserBook = apiConsume.getData(URI + "?search=" +
                URLEncoder.encode(userBook, StandardCharsets.UTF_8));
        var dataSearch = convertData.getData(jsonUserBook, Data.class);
        Optional<BookData> searchedBook = dataSearch.booksResults().stream()
                .filter(book -> book.title().toUpperCase().contains(userBook.toUpperCase()))
                .findFirst();
        if (searchedBook.isPresent()){
            System.out.println("Book found: ");
            System.out.println(searchedBook.get());
        } else {
            System.out.println("No match found!");
        }

        // Working with statistics.
        DoubleSummaryStatistics statistics = data.booksResults().stream()
                .filter(download -> download.downloads() > 0)
                .collect(Collectors.summarizingDouble(BookData::downloads));
        System.out.println("Mean downloads: " + statistics.getAverage());
        System.out.println("Max downloads: " + statistics.getMax());
        System.out.println("Min downloads: " + statistics.getMin());
        System.out.println("Total downloads: " + statistics.getCount());


    }
}
