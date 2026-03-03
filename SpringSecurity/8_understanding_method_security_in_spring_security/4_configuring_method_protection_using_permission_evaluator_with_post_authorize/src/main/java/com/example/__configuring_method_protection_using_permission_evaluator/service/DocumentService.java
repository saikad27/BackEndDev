package com.example.__configuring_method_protection_using_permission_evaluator.service;

import com.example.__configuring_method_protection_using_permission_evaluator.model.Document;
import com.example.__configuring_method_protection_using_permission_evaluator.repository.DocumentRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository){
        this.documentRepository = documentRepository;
    }

    @PostAuthorize("hasPermission(returnObject,'ROLE_ADMIN')")
    public Document getDocument(String code){
        return documentRepository.findDocumentById(code);
    }
}
