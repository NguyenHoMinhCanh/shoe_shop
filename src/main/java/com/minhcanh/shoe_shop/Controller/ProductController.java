package com.minhcanh.shoe_shop.Controller;

import com.minhcanh.shoe_shop.Entity.Product;
import com.minhcanh.shoe_shop.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public Product save(@RequestBody  Product product) {
        return productService.save(product);

    }

}
