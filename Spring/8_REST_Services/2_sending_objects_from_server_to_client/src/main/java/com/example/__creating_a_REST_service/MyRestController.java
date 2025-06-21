package com.example.__creating_a_REST_service;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MyRestController {

    @GetMapping("/country")
    public Country country(){
         return Country.getCountry("India",1250000000);
    }

    @GetMapping("/list")
    public List<Country> countryList(){
        Country c1 = Country.getCountry("Switzerland",10);
        Country c2 = Country.getCountry("Russia",120);
        return List.of(c1,c2);
    }
}
