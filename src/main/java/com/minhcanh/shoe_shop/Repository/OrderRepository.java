package com.minhcanh.shoe_shop.Repository;

import com.minhcanh.shoe_shop.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
