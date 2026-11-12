package com.example.rest_soap_graphql_api_tutorial.graphql;

import java.util.Arrays;
import java.util.List;

public record Author(String id, String firstName, String lastName) {
    private static List<Author> authors = Arrays.asList(
            new Author("author-1","Laurentu","Splicà"),
            new Author("author-2","Magnus","Larrson")
    );

    public static Author getById(String id){
        return authors.stream().filter(a -> a.id().equals(id)).findFirst().orElse(null);
    }
}
