package com.minhcanh.shoe_shop.Controller;

import com.minhcanh.shoe_shop.Entity.Product;
import com.minhcanh.shoe_shop.Entity.ProductSize;
import com.minhcanh.shoe_shop.Repository.ProductSizeRepository;
import com.minhcanh.shoe_shop.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductSizeRepository productSizeRepository;

    // Lấy tất cả sản phẩm (public)
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    // Lấy chi tiết 1 sản phẩm (public)
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    // Lấy sizes của sản phẩm (public)
    @GetMapping("/{id}/sizes")
    public List<ProductSize> getSizes(@PathVariable Long id) {
        return productSizeRepository.findByProductId(id);
    }

    // Tạo sản phẩm mới (admin)
    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }
}
