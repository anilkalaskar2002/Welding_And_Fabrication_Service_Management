package com.example.CrudOperation.Repostaries;

import com.example.CrudOperation.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {
    List<Contact> findByProcessedFalse();

    List<Contact> findAllByOrderBySubmittedAtDesc();
}