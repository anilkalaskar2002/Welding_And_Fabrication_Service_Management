package com.example.CrudOperation.Controller;

import com.example.CrudOperation.Model.Product;
import com.example.CrudOperation.Service.ProductService;
import com.example.CrudOperation.Service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private FileUploadService fileUploadService;

    // Home page - Display available products
    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = productService.getAvailableProducts();
        model.addAttribute("products", products);
        return "home";
    }

    // Admin: List all products
    @GetMapping("/admin/products")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin/products";
    }

    // Admin: Show add product form
    @GetMapping("/admin/products/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "admin/add-product";
    }

    // Admin: Add new product
    @PostMapping("/admin/products/add")
    public String addProduct(@ModelAttribute Product product,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            RedirectAttributes redirectAttributes) {
        try {
            // Handle file upload if provided
            if (imageFile != null && !imageFile.isEmpty()) {
                String uploadedImageUrl = fileUploadService.uploadFile(imageFile);
                if (uploadedImageUrl != null) {
                    product.setImageUrl(uploadedImageUrl);
                }
            }

            productService.addProduct(product);
            redirectAttributes.addFlashAttribute("message", "Product added successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error adding product: " + e.getMessage());
        }
        return "redirect:/admin/products";
    }

    // Admin: Show edit product form
    @GetMapping("/admin/products/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id).orElse(null);
        if (product == null) {
            return "redirect:/admin/products";
        }
        model.addAttribute("product", product);
        return "admin/edit-product";
    }

    // Admin: Update product
    @PostMapping("/admin/products/edit/{id}")
    public String updateProduct(@PathVariable Long id,
            @ModelAttribute Product product,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            RedirectAttributes redirectAttributes) {
        try {
            // Get existing product to check if we need to delete old image
            Product existingProduct = productService.getProductById(id).orElse(null);
            String oldImageUrl = null;
            if (existingProduct != null) {
                oldImageUrl = existingProduct.getImageUrl();
            }

            // Handle file upload if provided
            if (imageFile != null && !imageFile.isEmpty()) {
                String uploadedImageUrl = fileUploadService.uploadFile(imageFile);
                if (uploadedImageUrl != null) {
                    product.setImageUrl(uploadedImageUrl);
                    // Delete old image if it was uploaded (not a URL)
                    if (oldImageUrl != null && oldImageUrl.startsWith("/uploads/")) {
                        fileUploadService.deleteFile(oldImageUrl);
                    }
                }
            } else if (product.getImageUrl() == null || product.getImageUrl().trim().isEmpty()) {
                // If no new image and imageUrl is empty, delete old uploaded image
                if (oldImageUrl != null && oldImageUrl.startsWith("/uploads/")) {
                    fileUploadService.deleteFile(oldImageUrl);
                }
            }

            product.setId(id);
            productService.updateProduct(product);
            redirectAttributes.addFlashAttribute("message", "Product updated successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating product: " + e.getMessage());
        }
        return "redirect:/admin/products";
    }

    // Admin: Delete product
    @GetMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            // Get product to delete associated image
            Product product = productService.getProductById(id).orElse(null);
            if (product != null && product.getImageUrl() != null && product.getImageUrl().startsWith("/uploads/")) {
                fileUploadService.deleteFile(product.getImageUrl());
            }

            productService.deleteProduct(id);
            redirectAttributes.addFlashAttribute("message", "Product deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error deleting product: " + e.getMessage());
        }
        return "redirect:/admin/products";
    }

    // Cart page
    @GetMapping("/cart")
    public String showCart(Model model) {
        List<Product> products = productService.getAvailableProducts();
        model.addAttribute("products", products);
        return "cart";
    }
}