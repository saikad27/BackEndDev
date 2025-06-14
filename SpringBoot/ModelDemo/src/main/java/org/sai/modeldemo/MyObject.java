package org.sai.modeldemo;

public class MyObject{
    private String key;
    private String value;
    public void setName(String key){
        this.key = key;
    }
    public void setValue(String value){
        this.value = value;
    }
    public String toString(){
        return "Key : "+key+" ,Value : "+value;
    }
}
