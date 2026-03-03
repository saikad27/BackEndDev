package com.example.__using_csrf_token_to_make_post_request.filter;

import jakarta.servlet.*;
import org.springframework.security.web.csrf.CsrfToken;

import java.io.IOException;
import java.util.logging.Logger;


public class CsrfTokenLoggerFilter implements Filter {
    private CsrfToken csrfToken;
    private final Logger logger = Logger.getLogger(CsrfTokenLoggerFilter.class.getName());
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //Every request receives fresh DeferredCsrfFilter which is returned by the servletRequest.getAttribute method
        //and the getToken() method when called for the first time creates an instance
        if(csrfToken==null) {
            csrfToken = (CsrfToken) servletRequest.getAttribute("_csrf");
        }
        System.out.println(System.identityHashCode(csrfToken));
        logger.info("CSRF token : "+csrfToken.getToken());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
