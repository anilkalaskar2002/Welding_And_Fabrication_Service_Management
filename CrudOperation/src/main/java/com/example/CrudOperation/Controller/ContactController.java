package com.example.CrudOperation.Controller;

import com.example.CrudOperation.Model.Contact;
import com.example.CrudOperation.Model.Product;
import com.example.CrudOperation.Service.ContactService;
import com.example.CrudOperation.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ProductService productService;

    // Submit contact form
    @PostMapping("/submit")
    public String submitContact(@ModelAttribute Contact contact, RedirectAttributes redirectAttributes) {
        contactService.saveContact(contact);
        redirectAttributes.addFlashAttribute("message", "Thank you for your inquiry! We'll get back to you soon.");
        return "redirect:/cart";
    }

    // Admin: View all contacts
    @GetMapping("/admin/contacts")
    public String listContacts(Model model) {
        List<Contact> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "admin/contacts";
    }

    // Admin: View contact details
    @GetMapping("/admin/contacts/{id}")
    public String viewContact(@PathVariable Long id, Model model) {
        Contact contact = contactService.getContactById(id).orElse(null);
        if (contact == null) {
            return "redirect:/contact/admin/contacts";
        }

        // Fetch selected products details
        List<Product> selectedProductsDetails = new ArrayList<>();
        if (contact.getSelectedProducts() != null && !contact.getSelectedProducts().trim().isEmpty()) {
            String[] productIds = contact.getSelectedProducts().split(",");
            for (String productId : productIds) {
                try {
                    Long idLong = Long.parseLong(productId.trim());
                    productService.getProductById(idLong).ifPresent(selectedProductsDetails::add);
                } catch (NumberFormatException e) {
                    // Skip invalid product IDs
                }
            }
        }

        model.addAttribute("contact", contact);
        model.addAttribute("selectedProductsDetails", selectedProductsDetails);
        return "admin/contact-detail";
    }

    // Admin: Mark contact as processed
    @GetMapping("/admin/contacts/{id}/process")
    public String markAsProcessed(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        contactService.markAsProcessed(id);
        redirectAttributes.addFlashAttribute("message", "Contact marked as processed!");
        return "redirect:/contact/admin/contacts";
    }

    // Admin: Delete contact
    @GetMapping("/admin/contacts/{id}/delete")
    public String deleteContact(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        contactService.deleteContact(id);
        redirectAttributes.addFlashAttribute("message", "Contact deleted successfully!");
        return "redirect:/contact/admin/contacts";
    }
}