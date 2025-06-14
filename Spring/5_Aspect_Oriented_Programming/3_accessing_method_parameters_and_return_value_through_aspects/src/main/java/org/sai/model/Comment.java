package org.sai.model;

public class Comment {
    private String text;
    private String author;
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    @Override
    public String toString(){
        return "{"+this.getClass().getName()+":[text:"+text+",author:"+author+"]}";
    }
}
