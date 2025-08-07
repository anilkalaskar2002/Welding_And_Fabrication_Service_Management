package com.example.CrudOperation.Config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String requestURI = request.getRequestURI();

        // Allow access to login, forgot password, and reset password pages
        if (requestURI.startsWith("/admin/login") ||
                requestURI.startsWith("/admin/forgot-password") ||
                requestURI.startsWith("/admin/reset-password")) {
            return true;
        }

        // Check if user is logged in for other admin routes
        if (requestURI.startsWith("/admin/")) {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("adminLoggedIn") == null) {
                response.sendRedirect("/admin/login");
                return false;
            }
        }

        return true;
    }
}