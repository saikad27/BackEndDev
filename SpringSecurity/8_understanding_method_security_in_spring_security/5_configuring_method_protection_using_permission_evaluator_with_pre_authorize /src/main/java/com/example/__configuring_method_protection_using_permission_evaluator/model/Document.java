package com.example.__configuring_method_protection_using_permission_evaluator.model;

public class Document {
    private String owner;

    public Document(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Document{" +
                "owner='" + owner + '\'' +
                '}';
    }
}
