package com.example.CrudOperation.Controller;

import com.example.CrudOperation.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Show login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "admin/login";
    }

    // Handle login
    @PostMapping("/login")
    public String login(@RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        if (adminService.authenticate(username, password)) {
            session.setAttribute("adminLoggedIn", true);
            session.setAttribute("adminUsername", username);
            redirectAttributes.addFlashAttribute("message", "Welcome back, " + username + "!");
            return "redirect:/admin/products";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/admin/login";
        }
    }

    // Handle logout
    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("message", "You have been logged out successfully");
        return "redirect:/admin/login";
    }

    // Show forgot password page
    @GetMapping("/forgot-password")
    public String showForgotPasswordPage() {
        return "admin/forgot-password";
    }

    // Handle forgot password request
    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String username,
            RedirectAttributes redirectAttributes) {

        String resetToken = adminService.generateResetToken(username);
        if (resetToken != null) {
            // In a real application, you would send this token via email
            // For now, we'll show it on the page (not secure for production)
            redirectAttributes.addFlashAttribute("message",
                    "Reset token generated successfully. Use this token to reset your password: " + resetToken);
            redirectAttributes.addFlashAttribute("resetToken", resetToken);
        } else {
            redirectAttributes.addFlashAttribute("error", "Username not found or account is inactive");
        }
        return "redirect:/admin/forgot-password";
    }

    // Show reset password page
    @GetMapping("/reset-password")
    public String showResetPasswordPage(@RequestParam(required = false) String token, Model model) {
        if (token != null && adminService.isResetTokenValid(token)) {
            model.addAttribute("token", token);
            return "admin/reset-password";
        } else {
            return "redirect:/admin/forgot-password";
        }
    }

    // Handle password reset
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String token,
            @RequestParam String newPassword,
            @RequestParam String confirmPassword,
            RedirectAttributes redirectAttributes) {

        if (!newPassword.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("error", "Passwords do not match");
            return "redirect:/admin/reset-password?token=" + token;
        }

        if (newPassword.length() < 6) {
            redirectAttributes.addFlashAttribute("error", "Password must be at least 6 characters long");
            return "redirect:/admin/reset-password?token=" + token;
        }

        if (adminService.resetPassword(token, newPassword)) {
            redirectAttributes.addFlashAttribute("message",
                    "Password reset successfully. You can now login with your new password.");
            return "redirect:/admin/login";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid or expired reset token");
            return "redirect:/admin/forgot-password";
        }
    }
}