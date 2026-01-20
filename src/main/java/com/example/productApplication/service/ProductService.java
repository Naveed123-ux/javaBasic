package com.example.productApplication.service;

import com.example.productApplication.dto.ProductDTO;
import com.example.productApplication.entity.Category;
import com.example.productApplication.entity.Product;
import com.example.productApplication.mapper.ProductMapper;
import com.example.productApplication.repositry.CategoryRepositry;
import com.example.productApplication.repositry.ProductRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepositry productRepositry;
    private CategoryRepositry categoryRepositry;

  public ProductDTO createProduct(ProductDTO productDTO){
    System.out.println("categrory ID"+ productDTO);
      Category category=categoryRepositry.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category not found!"));

      Product product=ProductMapper.ToProductEntity(productDTO,category);

      return  ProductMapper.toProductDTO(productRepositry.save(product));
  }
}
