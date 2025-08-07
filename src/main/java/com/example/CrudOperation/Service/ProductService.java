package com.example.CrudOperation.Service;

import com.example.CrudOperation.Model.Product;
import com.example.CrudOperation.Repostaries.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> getAvailableProducts() {
        return productRepo.findByAvailableTrue();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepo.findByCategory(category);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    // Search methods for public pages (available products only)
    public List<Product> searchAvailableProducts(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return getAvailableProducts();
        }
        return productRepo.searchAvailableProducts(searchTerm.trim());
    }

    public List<Product> searchAvailableProductsByCategory(String category, String searchTerm) {
        if (category == null || category.trim().isEmpty()) {
            return searchAvailableProducts(searchTerm);
        }
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return getProductsByCategory(category.trim());
        }
        return productRepo.searchAvailableProductsByCategory(category.trim(), searchTerm.trim());
    }

    // Search methods for admin pages (all products)
    public List<Product> searchAllProducts(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return getAllProducts();
        }
        return productRepo.searchAllProducts(searchTerm.trim());
    }

    public List<Product> searchAllProductsByCategory(String category, String searchTerm) {
        if (category == null || category.trim().isEmpty()) {
            return searchAllProducts(searchTerm);
        }
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return getProductsByCategory(category.trim());
        }
        return productRepo.searchAllProductsByCategory(category.trim(), searchTerm.trim());
    }

    // Get categories for dropdowns
    public List<String> getAvailableCategories() {
        return productRepo.findAvailableCategories();
    }

    public List<String> getAllCategories() {
        return productRepo.findAllCategories();
    }
}