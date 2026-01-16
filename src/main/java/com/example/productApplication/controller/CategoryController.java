package com.example.productApplication.controller;

import com.example.productApplication.dto.CategoryDTO;
import com.example.productApplication.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {


   private CategoryService categoryService;

//   get all categories
    @GetMapping
   public List<CategoryDTO> getAllCategories(){
       return  categoryService.getAllCategories();
   }


    //   get  category by id
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id, HttpServletRequest httpServletRequest){
        //httpServletRequest.authenticate();
        return  categoryService.getCategoryById(id);
    }

    //    create  Category
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
      return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
    }

}
