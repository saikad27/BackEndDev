package com.example.__creating_a_REST_service;

//This class is a DTO (Data Transfer Object)

public class Country {
    private String name;
    private int population;

    public static Country getCountry(String name,int population){
        Country country = new Country();
        country.setName(name);
        country.setPopulation(population);
        return country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
