package com.example.productApplication.service;

import com.example.productApplication.dto.CategoryDTO;
import com.example.productApplication.entity.Category;
import com.example.productApplication.exception.CategoryAlreadyExistsException;
import com.example.productApplication.mapper.CategoryMapper;
import com.example.productApplication.mapper.ProductMapper;
import com.example.productApplication.repositry.CategoryRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Service
public class CategoryService {

    private CategoryRepositry categoryRepositry;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Optional<Category> optionalCategory=categoryRepositry.findByName(categoryDTO.getName());
        if(optionalCategory.isPresent()){
            throw  new CategoryAlreadyExistsException("Category "+categoryDTO.getName()+" already exists");
        }
        Category category=CategoryMapper.toCategoryEntity(categoryDTO);
       category=categoryRepositry.save(category);
       return  CategoryMapper.toCategoryDTO(category);
    }

    public List<CategoryDTO> getAllCategories(){
        return categoryRepositry.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    public CategoryDTO getCategoryById(Long id){
        Category category=categoryRepositry.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        return CategoryMapper.toCategoryDTO(category);
    }
}
