package com.example.__configuring_method_protection_using_permission_evaluator.controller;


import com.example.__configuring_method_protection_using_permission_evaluator.model.Document;
import com.example.__configuring_method_protection_using_permission_evaluator.service.DocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DocumentController {

    private final DocumentService  documentService;

    public DocumentController(DocumentService  documentService){
        this.documentService = documentService;
    }

    @GetMapping("/document/{code}")
    public Document getDocument(@PathVariable String code){
        return documentService.getDocument(code);
    }
}
