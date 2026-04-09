package com.minhcanh.shoe_shop.Service;

import com.minhcanh.shoe_shop.Entity.Cart;
import com.minhcanh.shoe_shop.Entity.CartItem;
import com.minhcanh.shoe_shop.Entity.Product;
import com.minhcanh.shoe_shop.Entity.User;
import com.minhcanh.shoe_shop.Repository.CartItemRepository;
import com.minhcanh.shoe_shop.Repository.CartRepository;
import com.minhcanh.shoe_shop.Repository.ProductRepository;
import com.minhcanh.shoe_shop.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    // Lấy cart của user, tạo mới nếu chưa có
    public Cart getCartByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));

        return cartRepository.findByUserId(user.getId())
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    newCart.setItems(new ArrayList<>());
                    return cartRepository.save(newCart);
                });
    }

    // Thêm sản phẩm vào giỏ với size cụ thể
    public Cart addToCart(String username, Long productId, int quantity, String size) {
        Cart cart = getCartByUsername(username);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

        // Kiểm tra đã có item với đúng productId + size chưa
        CartItem item = cartItemRepository
                .findByCartIdAndProductIdAndSize(cart.getId(), productId, size)
                .orElse(null);

        if (item != null) {
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            item = new CartItem();
            item.setCart(cart);
            item.setProduct(product);
            item.setQuantity(quantity);
            item.setSize(size);
        }

        cartItemRepository.save(item);
        return getCartByUsername(username);
    }

    // Xóa 1 item khỏi giỏ
    public Cart removeItem(String username, Long cartItemId) {
        Cart cart = getCartByUsername(username);
        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        if (!item.getCart().getId().equals(cart.getId())) {
            throw new RuntimeException("Unauthorized");
        }
        cartItemRepository.delete(item);
        return getCartByUsername(username);
    }

    // Xóa toàn bộ giỏ
    public void clearCart(String username) {
        Cart cart = getCartByUsername(username);
        cartItemRepository.deleteAll(cart.getItems());
        cart.setItems(new ArrayList<>());
        cartRepository.save(cart);
    }
}
