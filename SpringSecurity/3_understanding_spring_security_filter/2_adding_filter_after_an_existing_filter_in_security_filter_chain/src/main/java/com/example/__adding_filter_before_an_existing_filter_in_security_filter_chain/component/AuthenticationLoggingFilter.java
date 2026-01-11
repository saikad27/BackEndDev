package com.example.__adding_filter_before_an_existing_filter_in_security_filter_chain.component;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingFilter implements Filter {
    private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestId = httpServletRequest.getHeader("Request-Id");
        logger.info("Successfully authenticated with request-id : "+requestId);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
