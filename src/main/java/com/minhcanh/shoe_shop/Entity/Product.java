package com.minhcanh.shoe_shop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tu dong tang gia tri id primary key
    private Long id;
    private String name;
    private String brand;
    private Double price;
    private Integer stock; // so luong
    @Column(length = 1000)
    private String description;
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
