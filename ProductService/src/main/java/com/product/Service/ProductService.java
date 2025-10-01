package com.product.Service;

import com.product.Entity.Category;
import com.product.Entity.Product;
import com.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.addProduct(product);
    }

    public Category createCategory(Category category) {
        return productRepository.addCategory(category);
    }

}
