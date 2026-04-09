package com.minhcanh.shoe_shop.Controller;

import com.minhcanh.shoe_shop.Entity.Cart;
import com.minhcanh.shoe_shop.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    // Lấy giỏ hàng của user đang đăng nhập
    @GetMapping
    public Cart getCart(Principal principal) {
        return cartService.getCartByUsername(principal.getName());
    }

    // Thêm sản phẩm vào giỏ (yêu cầu đăng nhập)
    @PostMapping("/add")
    public Cart addToCart(Principal principal,
                          @RequestParam Long productId,
                          @RequestParam int quantity,
                          @RequestParam String size) {
        return cartService.addToCart(principal.getName(), productId, quantity, size);
    }

    // Xóa 1 item khỏi giỏ
    @DeleteMapping("/item/{itemId}")
    public Cart removeItem(Principal principal, @PathVariable Long itemId) {
        return cartService.removeItem(principal.getName(), itemId);
    }

    // Xóa toàn bộ giỏ
    @DeleteMapping("/clear")
    public String clearCart(Principal principal) {
        cartService.clearCart(principal.getName());
        return "Đã xóa giỏ hàng";
    }
}
