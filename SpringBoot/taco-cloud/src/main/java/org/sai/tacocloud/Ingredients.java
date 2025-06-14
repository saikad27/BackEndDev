package org.sai.tacocloud;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
//@RequiredArgsConstructor
public class Ingredients {
    private final String id;
    private final String name;
    private final Type type;
    public Ingredients(String id,String name,Type type){
        this.id = id;
        this.name = name;
        this.type = type;
    }


    public enum Type{
        WRAP,CHEESE,VEGGIE,PROTEIN,SAUCE
    }
}
