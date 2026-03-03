package com.example.__configuring_method_protection_using_permission_evaluator.method_security.component;

import com.example.__configuring_method_protection_using_permission_evaluator.model.Document;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class DocumentPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication,Object subject,Object permission){
        Document document = (Document) subject;
        String role = (String) permission;
        boolean admin = authentication.getAuthorities().stream().anyMatch( a -> a.getAuthority().equals(role));
        return admin || authentication.getName().equals(document.getOwner());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable objectId,String Objecttype,Object permission){
        return false;
    }

}
