package com.example.productApplication.mapper;


import com.example.productApplication.dto.CategoryDTO;
import com.example.productApplication.dto.ProductDTO;
import com.example.productApplication.entity.Category;
import com.example.productApplication.entity.Product;

public class ProductMapper {

    public  static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
         product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCategory().getId()
        );
    }

    public static Product ToProductEntity(ProductDTO productDTO, Category category){
        Product product=new Product();
        product.setName(product.getName());
        product.setPrice(product.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCategory(category);
        return product;
    }
}
