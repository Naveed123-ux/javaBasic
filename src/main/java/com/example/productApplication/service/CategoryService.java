package com.example.productApplication.service;

import com.example.productApplication.dto.CategoryDTO;
import com.example.productApplication.entity.Category;
import com.example.productApplication.mapper.CategoryMapper;
import com.example.productApplication.repositry.CategoryRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor

@Service
public class CategoryService {

    private CategoryRepositry categoryRepositry;
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category=CategoryMapper.toCategoryEntity(categoryDTO);
       category=categoryRepositry.save(category);
       return  CategoryMapper.toCategoryDTO(category);
    }

}
