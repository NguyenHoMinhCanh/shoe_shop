package com.minhcanh.shoe_shop.Repository;

import com.minhcanh.shoe_shop.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserIdOrderByCreateAtDesc(Long userId);
}
