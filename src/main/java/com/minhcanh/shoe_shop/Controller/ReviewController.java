package com.minhcanh.shoe_shop.Controller;

import com.minhcanh.shoe_shop.Entity.Review;
import com.minhcanh.shoe_shop.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    // Lấy tất cả review của 1 sản phẩm (public)
    @GetMapping("/product/{productId}")
    public List<Review> getByProduct(@PathVariable Long productId) {
        return reviewService.getByProductId(productId);
    }

    // Gửi đánh giá (cần đăng nhập)
    @PostMapping
    public Review addReview(Principal principal, @RequestBody Map<String, Object> body) {
        Long productId = Long.parseLong(body.get("productId").toString());
        int rating = Integer.parseInt(body.get("rating").toString());
        String comment = body.getOrDefault("comment", "").toString();
        return reviewService.addReview(principal.getName(), productId, rating, comment);
    }
}
