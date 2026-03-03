package com.example.__implementing_custom_csrf_token_repository_to_store_tokens_in_a_database.repo;

import com.example.__implementing_custom_csrf_token_repository_to_store_tokens_in_a_database.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface JpaTokenRepository extends JpaRepository<Token,Integer> {
    Optional<Token> findTokenByIdentifier(String identifier);
}
