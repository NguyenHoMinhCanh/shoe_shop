package com.minhcanh.shoe_shop.Repository;

import com.minhcanh.shoe_shop.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
