package com.curpatient.empoperations.security;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiKeyFilter extends OncePerRequestFilter {
    private static final String API_KEY_HEADER = "X-API-KEY";
    private static final String API_KEY_VALUE = "HARD_CODED_API_KEY";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String apiKey = request.getHeader(API_KEY_HEADER);
        if (!API_KEY_VALUE.equals(apiKey)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid API Key");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
