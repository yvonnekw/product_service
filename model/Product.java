package com.auction.product_service.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String brandName;
    private String description;
    private String colour;
    private String size;
    private Double startingPrice;

    private Long sellerId;  // Reference to UserService

    private boolean isSold;  // Track if the product is sold
    private Long winnerId;   // Reference to the winning user
    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

}
