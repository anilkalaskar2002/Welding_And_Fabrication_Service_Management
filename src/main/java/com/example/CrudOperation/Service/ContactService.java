package com.example.CrudOperation.Service;

import com.example.CrudOperation.Model.Contact;
import com.example.CrudOperation.Repostaries.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepo contactRepo;

    public List<Contact> getAllContacts() {
        return contactRepo.findAllByOrderBySubmittedAtDesc();
    }

    public List<Contact> getUnprocessedContacts() {
        return contactRepo.findByProcessedFalse();
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepo.findById(id);
    }

    public Contact saveContact(Contact contact) {
        return contactRepo.save(contact);
    }

    public Contact markAsProcessed(Long id) {
        Optional<Contact> contactOpt = contactRepo.findById(id);
        if (contactOpt.isPresent()) {
            Contact contact = contactOpt.get();
            contact.setProcessed(true);
            return contactRepo.save(contact);
        }
        return null;
    }

    public void deleteContact(Long id) {
        contactRepo.deleteById(id);
    }
}