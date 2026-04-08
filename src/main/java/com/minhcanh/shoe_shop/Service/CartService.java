package com.minhcanh.shoe_shop.Service;

import com.minhcanh.shoe_shop.Entity.Cart;
import com.minhcanh.shoe_shop.Entity.CartItem;
import com.minhcanh.shoe_shop.Entity.Product;
import com.minhcanh.shoe_shop.Repository.CartItemRepository;
import com.minhcanh.shoe_shop.Repository.CartRepository;
import com.minhcanh.shoe_shop.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    // chỉ có 1 cart (chưa login)
    public Cart getCart() {
        return cartRepository.findAll()
                .stream()
                .findFirst()
                .orElseGet(() -> cartRepository.save(new Cart()));
    }

    // Thêm vào giỏ
    public Cart addToCart(Long productId, int quantity) {
        Cart cart = getCart();
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // kiem tra da co chua
        CartItem item = cartItemRepository
                .findByCartAndProductId(cart.getId(), productId)
                .orElse(null);
        if (item != null) {
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            item = new CartItem();
            item.setCart(cart);
            item.setProduct(product);
            item.setQuantity(quantity);
        }

        cartItemRepository.save(item);
        return getCart();

    }

    public void clearCart() {
        Cart cart = getCart();
        cartItemRepository.deleteAll(cart.getItems());
        cart.setItems(new ArrayList<>());
        cartRepository.save(cart);
    }
}
