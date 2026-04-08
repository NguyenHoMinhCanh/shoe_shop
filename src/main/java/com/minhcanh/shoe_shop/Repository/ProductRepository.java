package com.minhcanh.shoe_shop.Repository;

import com.minhcanh.shoe_shop.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
