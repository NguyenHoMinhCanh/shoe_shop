package com.minhcanh.shoe_shop.Repository;

import com.minhcanh.shoe_shop.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query("SELECT ci FROM CartItem ci WHERE ci.cart.id = :cartId AND ci.product.id = :productId AND ci.size = :size")
    Optional<CartItem> findByCartIdAndProductIdAndSize(Long cartId, Long productId, String size);
}
