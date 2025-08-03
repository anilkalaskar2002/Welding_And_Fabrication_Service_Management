package com.example.CrudOperation.Repostaries;

import com.example.CrudOperation.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByAvailableTrue();

    List<Product> findByCategory(String category);
}