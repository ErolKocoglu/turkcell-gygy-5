package com.turkcell.spring_cqrs.core.security.filter;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                // request -> istek
                // response -> response'ın o ana kadarki oluşan halini 
                // filterChain -> zincirin kendisi
            String jwtHeader = request.getHeader("Authorization");

            if(jwtHeader != null) {
                String token = jwtHeader.substring(7);
            }

            filterChain.doFilter(request, response); // chaini ilerlet..
    }

}
