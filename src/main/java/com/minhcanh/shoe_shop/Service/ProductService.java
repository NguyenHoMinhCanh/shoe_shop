package com.minhcanh.shoe_shop.Service;

import com.minhcanh.shoe_shop.Entity.Product;
import com.minhcanh.shoe_shop.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
