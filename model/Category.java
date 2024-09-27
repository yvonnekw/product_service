package com.auction.product_service.model;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;         // The name of the category (e.g., "Electronics", "Furniture", etc.)

    private String description;  // A short description of the category (optional)

    private Long parentId;       // If you want to implement a category hierarchy, this points to the parent category (nullable)

    // Additional fields, depending on your requirements
    private boolean isActive;    // To indicate if the category is active or disabled

    // Constructor, getters, and setters
}
