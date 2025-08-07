package com.example.CrudOperation.Service;

import com.example.CrudOperation.Model.Admin;
import com.example.CrudOperation.Repostaries.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public boolean authenticate(String username, String password) {
        Optional<Admin> adminOpt = adminRepo.findByUsernameAndActiveTrue(username);
        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            // In a real application, you should use BCrypt or similar for password hashing
            if (admin.getPassword().equals(password)) {
                admin.setLastLogin(LocalDateTime.now());
                adminRepo.save(admin);
                return true;
            }
        }
        return false;
    }

    public Optional<Admin> getAdminByUsername(String username) {
        return adminRepo.findByUsernameAndActiveTrue(username);
    }

    public String generateResetToken(String username) {
        Optional<Admin> adminOpt = adminRepo.findByUsernameAndActiveTrue(username);
        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            String resetToken = UUID.randomUUID().toString();
            admin.setResetToken(resetToken);
            admin.setResetTokenExpiry(LocalDateTime.now().plusHours(24)); // Token expires in 24 hours
            adminRepo.save(admin);
            return resetToken;
        }
        return null;
    }

    public boolean resetPassword(String resetToken, String newPassword) {
        Optional<Admin> adminOpt = adminRepo.findByResetToken(resetToken);
        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            if (admin.getResetTokenExpiry() != null &&
                    admin.getResetTokenExpiry().isAfter(LocalDateTime.now())) {
                admin.setPassword(newPassword);
                admin.setResetToken(null);
                admin.setResetTokenExpiry(null);
                adminRepo.save(admin);
                return true;
            }
        }
        return false;
    }

    public boolean isResetTokenValid(String resetToken) {
        Optional<Admin> adminOpt = adminRepo.findByResetToken(resetToken);
        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            return admin.getResetTokenExpiry() != null &&
                    admin.getResetTokenExpiry().isAfter(LocalDateTime.now());
        }
        return false;
    }

    public void clearExpiredTokens() {
        // This method can be called periodically to clean up expired tokens
        // For now, we'll handle this in the resetPassword method
    }
}