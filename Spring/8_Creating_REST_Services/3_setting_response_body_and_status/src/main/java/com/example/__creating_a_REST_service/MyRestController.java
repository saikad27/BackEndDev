package com.example.__creating_a_REST_service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MyRestController {

    @GetMapping("/country")
    public ResponseEntity<Country> country() {
        Country c = Country.getCountry("France",67);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent","Europe")
                .header("capital","Paris")
                .header("favorite food","cheese and Wine")
                .body(c);
    }
}
