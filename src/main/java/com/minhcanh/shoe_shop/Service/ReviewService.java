package com.minhcanh.shoe_shop.Service;

import com.minhcanh.shoe_shop.Entity.Product;
import com.minhcanh.shoe_shop.Entity.Review;
import com.minhcanh.shoe_shop.Entity.User;
import com.minhcanh.shoe_shop.Repository.ProductRepository;
import com.minhcanh.shoe_shop.Repository.ReviewRepository;
import com.minhcanh.shoe_shop.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public List<Review> getByProductId(Long productId) {
        return reviewRepository.findByProductIdOrderByCreatedAtDesc(productId);
    }

    public Review addReview(String username, Long productId, int rating, String comment) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setRating(rating);
        review.setComment(comment);
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }
}
