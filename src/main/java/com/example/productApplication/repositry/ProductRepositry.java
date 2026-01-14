package com.example.productApplication.repositry;

import com.example.productApplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositry extends JpaRepository<Product,Long> {
}
