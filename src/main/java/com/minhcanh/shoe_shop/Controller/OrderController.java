package com.minhcanh.shoe_shop.Controller;

import com.minhcanh.shoe_shop.Entity.Order;
import com.minhcanh.shoe_shop.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/checkout")
    public Order checkout() {
        return orderService.checkout();
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

}
