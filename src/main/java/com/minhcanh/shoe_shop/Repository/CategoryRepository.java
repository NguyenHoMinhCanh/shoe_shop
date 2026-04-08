package com.minhcanh.shoe_shop.Repository;

import com.minhcanh.shoe_shop.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
