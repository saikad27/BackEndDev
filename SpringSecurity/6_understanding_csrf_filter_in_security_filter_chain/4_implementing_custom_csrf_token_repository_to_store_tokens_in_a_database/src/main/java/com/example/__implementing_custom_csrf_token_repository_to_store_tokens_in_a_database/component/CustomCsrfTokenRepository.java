package com.example.__implementing_custom_csrf_token_repository_to_store_tokens_in_a_database.component;

import com.example.__implementing_custom_csrf_token_repository_to_store_tokens_in_a_database.entities.Token;
import com.example.__implementing_custom_csrf_token_repository_to_store_tokens_in_a_database.repo.JpaTokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomCsrfTokenRepository implements CsrfTokenRepository {
    private final JpaTokenRepository jpaTokenRepository;
    public CustomCsrfTokenRepository(JpaTokenRepository jpaTokenRepository){
        this.jpaTokenRepository = jpaTokenRepository;
    }

    //This method is called by the CsrfFilter only if the loadToken() returns null
    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        System.out.println("Generate Token method called");
        String uuid = UUID.randomUUID().toString();
        return new DefaultCsrfToken("X-CSRF-TOKEN","_csrf",uuid);
    }

    @Override
    public void saveToken(@Nullable CsrfToken csrfToken, HttpServletRequest request, HttpServletResponse response) {
        String identifier = request.getHeader("X-IDENTIFIER");
        System.out.println("Save Token method called");
        Token token = new Token();
        token.setIdentifier(identifier);
        try {
            token.setToken(csrfToken.getToken());
        }catch(NullPointerException e){
            e.printStackTrace();
            token.setToken(null);
        }
        try {
            jpaTokenRepository.save(token);
        }catch(Exception e){
            e.printStackTrace();
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }

    }

    @Override
    public @Nullable CsrfToken loadToken(HttpServletRequest request) {
        System.out.println("CsrfFilter is called loadToken() method");
        String identifier = request.getHeader("X-IDENTIFIER");
        Optional<Token> existingToken = jpaTokenRepository.findTokenByIdentifier(identifier);
        if(existingToken.isPresent()){
            return new DefaultCsrfToken("X-CSRF-TOKEN","_csrf",existingToken.get().getToken());
        }else{
            return null;
        }
    }
}
