package com.example.rest_soap_graphql_api_tutorial.graphql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.graphql.test.autoconfigure.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(BookController.class)
public class BookControllerTests {

    @Autowired
    GraphQlTester graphQlTester;

    @Test
    void shouldGetFirstBook() {
        this.graphQlTester
                .documentName("bookDetails")
                .variable("id","book-1")
                .execute()
                .path("bookById")
                .matchesJson("""
                        {
                            "id": "book-1",
                            "name": "Spring start here",
                            "pageCount": 659,
                            "author": {
                                "id": "author-1",
                                "firstName": "Laurentu",
                                "lastName": "Splicà"
                            }
                        }
                        """);
    }

}
