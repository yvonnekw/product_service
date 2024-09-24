package com.auction.product_service.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductRequest {
    private Long productId;
    private String productName;
    private String brandName;
    private String description;
    private String price;
    private String colour;
    private String size;
}
