package com.example.__implementing_custom_csrf_token_repository_to_store_tokens_in_a_database.entities;

import jakarta.persistence.*;

@Entity
@Table(name="csrf_token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="identifier")
    private String identifier;

    @Column(name="token")
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", identifier='" + identifier + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
