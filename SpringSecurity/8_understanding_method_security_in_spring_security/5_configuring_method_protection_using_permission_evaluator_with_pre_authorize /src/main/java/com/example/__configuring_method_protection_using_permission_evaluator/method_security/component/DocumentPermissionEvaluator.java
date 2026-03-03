package com.example.__configuring_method_protection_using_permission_evaluator.method_security.component;

import com.example.__configuring_method_protection_using_permission_evaluator.repository.DocumentRepository;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class DocumentPermissionEvaluator implements PermissionEvaluator {
    private final DocumentRepository documentRepository;

    public DocumentPermissionEvaluator(DocumentRepository documentRepository){
        this.documentRepository = documentRepository;
    }

    @Override
    public boolean hasPermission(Authentication authentication,Object subject,Object permission){
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable objectId,String Objecttype,Object permission){
        String id = (String) objectId;
        String role = (String) permission;
        boolean admin = authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(role));
        return admin || authentication.getName().equals(documentRepository.findDocumentById(id).getOwner());
    }

}
