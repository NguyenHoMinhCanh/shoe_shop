package com.minhcanh.shoe_shop.Controller;

import com.minhcanh.shoe_shop.Entity.Order;
import com.minhcanh.shoe_shop.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // Đặt hàng từ giỏ hàng hiện tại
    @PostMapping("/checkout")
    public Order checkout(Principal principal, @RequestBody Map<String, String> body) {
        String recipientName = body.getOrDefault("recipientName", "");
        String phone = body.getOrDefault("phone", "");
        String shippingAddress = body.getOrDefault("shippingAddress", "");
        return orderService.checkout(principal.getName(), recipientName, phone, shippingAddress);
    }

    // Lấy lịch sử đơn hàng của user
    @GetMapping
    public List<Order> getMyOrders(Principal principal) {
        return orderService.getAllByUsername(principal.getName());
    }
}
