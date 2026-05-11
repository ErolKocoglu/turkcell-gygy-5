package com.turkcell.spring_cqrs.core.security.context;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserContext {
    private String userId;
    private String email;
    private List<String> roles = Collections.EMPTY_LIST;
    private boolean isAuthenticated = false;
    
    
}
