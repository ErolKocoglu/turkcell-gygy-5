package com.turkcell.spring_cqrs.core.security.jwt;

import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(JwtProperties.class)
public class JwtService {
    private final JwtProperties jwtProperties;
    private final SecretKey signingKey;
    
    public JwtService(JwtProperties jwtProperties, SecretKey signingKey) {
        this.jwtProperties = jwtProperties;
        this.signingKey = signingKey;
    }

    
}
