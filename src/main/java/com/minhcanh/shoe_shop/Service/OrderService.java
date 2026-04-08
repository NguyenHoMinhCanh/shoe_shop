package com.minhcanh.shoe_shop.Service;

import com.minhcanh.shoe_shop.Entity.Cart;
import com.minhcanh.shoe_shop.Entity.CartItem;
import com.minhcanh.shoe_shop.Entity.Order;
import com.minhcanh.shoe_shop.Entity.OrderItem;
import com.minhcanh.shoe_shop.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;

    public Order checkout() {
        Cart cart = cartService.getCart();

        Order order = new Order();
        order.setCreateAt(LocalDateTime.now());
        order.setStatus("PENDING");

        List<OrderItem> orderItems = new ArrayList<>();
        double total =0;

        for (CartItem item : cart.getItems()) {
            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setProduct(item.getProduct());
            oi.setQuantity(item.getQuantity());
            oi.setPrice(item.getProduct().getPrice());

            total += item.getQuantity()*item.getProduct().getPrice();

            orderItems.add(oi);

        }

        order.setItems(orderItems);
        order.setTotalPrice(total);

        Order savedOrder = orderRepository.save(order);

        // clear cart sau khi đặt hàng
        cartService.clearCart();

        return savedOrder;

    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
