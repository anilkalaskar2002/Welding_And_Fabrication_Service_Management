package com.example.CrudOperation.Repostaries;

import com.example.CrudOperation.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByAvailableTrue();

    List<Product> findByCategory(String category);

    // Search by name or description containing search term
    @Query("SELECT p FROM Product p WHERE p.available = true AND (LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")
    List<Product> searchAvailableProducts(@Param("searchTerm") String searchTerm);

    // Search by category and name/description
    @Query("SELECT p FROM Product p WHERE p.available = true AND p.category = :category AND (LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")
    List<Product> searchAvailableProductsByCategory(@Param("category") String category,
            @Param("searchTerm") String searchTerm);

    // Search all products (for admin)
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Product> searchAllProducts(@Param("searchTerm") String searchTerm);

    // Search all products by category (for admin)
    @Query("SELECT p FROM Product p WHERE p.category = :category AND (LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")
    List<Product> searchAllProductsByCategory(@Param("category") String category,
            @Param("searchTerm") String searchTerm);

    // Get all available categories
    @Query("SELECT DISTINCT p.category FROM Product p WHERE p.available = true ORDER BY p.category")
    List<String> findAvailableCategories();

    // Get all categories (for admin)
    @Query("SELECT DISTINCT p.category FROM Product p ORDER BY p.category")
    List<String> findAllCategories();
}