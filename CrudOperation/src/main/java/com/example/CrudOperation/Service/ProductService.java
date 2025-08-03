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
}