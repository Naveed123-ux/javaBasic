package com.example.productApplication.service;

import com.example.productApplication.repositry.ProductRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdcutService {

    @Autowired
    private ProductRepositry productRepositry;


}
