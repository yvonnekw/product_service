package com.auction.product_service.dto;

import lombok.*;


@Builder
public record ProductRequest(Long productId, String productName, String brandName, String description, Double startingPrice, String colour, String size) {

}
