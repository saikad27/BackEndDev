package com.example.__configuring_method_protection_using_permission_evaluator.repository;


import com.example.__configuring_method_protection_using_permission_evaluator.model.Document;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DocumentRepository {

    private Map<String,Document> repo;
    public DocumentRepository(){
        repo = new HashMap<>();
        repo.put("111",new Document("natalie"));
        repo.put("222",new Document("natalie"));
        repo.put("333",new Document("emma"));
    }

    public Document findDocumentById(String id){
        return repo.get(id);
    }
}
