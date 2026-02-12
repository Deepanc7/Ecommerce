package com.product.Controllers;

import com.product.Entity.Product;
import com.product.Service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {

    ProductService productService;

    ProductController(ProductService productService) {
        this.productService=productService;
    }



}
