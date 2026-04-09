package com.minhcanh.shoe_shop.Service;

import com.minhcanh.shoe_shop.Entity.*;
import com.minhcanh.shoe_shop.Repository.OrderRepository;
import com.minhcanh.shoe_shop.Repository.UserRepository;
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
    private final UserRepository userRepository;

    public Order checkout(String username, String recipientName, String phone, String shippingAddress) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = cartService.getCartByUsername(username);

        if (cart.getItems() == null || cart.getItems().isEmpty()) {
            throw new RuntimeException("Giỏ hàng trống, không thể đặt hàng!");
        }

        Order order = new Order();
        order.setUser(user);
        order.setCreateAt(LocalDateTime.now());
        order.setStatus("PENDING");
        order.setRecipientName(recipientName);
        order.setPhone(phone);
        order.setShippingAddress(shippingAddress);

        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;

        for (CartItem item : cart.getItems()) {
            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setProduct(item.getProduct());
            oi.setQuantity(item.getQuantity());
            oi.setPrice(item.getProduct().getPrice());
            oi.setSize(item.getSize());

            total += item.getQuantity() * item.getProduct().getPrice();
            orderItems.add(oi);
        }

        order.setItems(orderItems);
        order.setTotalPrice(total);

        Order savedOrder = orderRepository.save(order);

        // Xóa giỏ sau khi đặt hàng thành công
        cartService.clearCart(username);

        return savedOrder;
    }

    public List<Order> getAllByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return orderRepository.findByUserIdOrderByCreateAtDesc(user.getId());
    }
}
