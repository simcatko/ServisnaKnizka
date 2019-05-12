package com.sima.servicebook.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        if (request.getServletPath().startsWith("/register")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (request.getServletPath().startsWith("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (request.getSession().getAttribute("user" ) == null) {
            response.sendRedirect("/login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
