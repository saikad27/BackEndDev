package com.example.__configuring_preauthorization_for_a_method_call.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NameService {

    Map<String,List<String>> secretNames = new HashMap<>();
    public NameService(){
        secretNames.put("natalie",List.of("Energico","Perfecto"));
        secretNames.put("emma",List.of("fantastico"));
    }

    @PreAuthorize("#name==authentication.principal.username")
    public List<String> getSecretNames(String name){
        return secretNames.get(name);
    }
}
