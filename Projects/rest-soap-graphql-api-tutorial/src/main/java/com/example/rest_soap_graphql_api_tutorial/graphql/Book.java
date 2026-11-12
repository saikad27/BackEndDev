package com.example.rest_soap_graphql_api_tutorial.graphql;

import java.util.Arrays;
import java.util.List;

public record Book(String id, String name, int pageCount, String authorId) {

    private static List<Book> books = Arrays.asList(
            new Book("book-1","Spring start here",659,"author-1"),
            new Book("book-2","Spring Security in Action",612,"author-1"),
            new Book("book-3","Microservices with Spring Cloud",683,"author-2")
    );
    public static Book getById(String id){
        return books.stream().filter(b -> b.id().equals(id)).findFirst().orElse(null);
    }
}
