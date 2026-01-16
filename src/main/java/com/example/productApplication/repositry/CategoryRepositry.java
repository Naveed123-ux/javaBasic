package com.example.productApplication.repositry;


import com.example.productApplication.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepositry extends JpaRepository<Category,Long> {

    Optional<Category> findByName(String name);
}
