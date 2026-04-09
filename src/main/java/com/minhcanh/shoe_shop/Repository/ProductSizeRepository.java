package com.minhcanh.shoe_shop.Repository;

import com.minhcanh.shoe_shop.Entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {
    List<ProductSize> findByProductId(Long productId);
}
