package com.product.Controllers;

import com.product.Entity.Category;
import com.product.Entity.Product;
import com.product.Service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    AdminService adminService;

    AdminController(AdminService adminService) {
        this.adminService=adminService;
    }

    @PostMapping("/add-product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(adminService.createProduct(product));
    }

    @PostMapping("/add-category")
    public ResponseEntity<Category> addProduct(@RequestBody Category category) {
        return ResponseEntity.ok(adminService.createCategory(category));
    }

    
}
