package com.example.CrudOperation.Repostaries;

import com.example.CrudOperation.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);

    Optional<Admin> findByResetToken(String resetToken);

    Optional<Admin> findByUsernameAndActiveTrue(String username);
}