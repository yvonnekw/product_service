package com.auction.product_service.service;

import com.auction.product_service.dto.ProductRequest;
import com.auction.product_service.dto.ProductResponse;
import com.auction.product_service.model.Product;
import com.auction.product_service.repostory.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequestBody) {

        Product product = Product.builder()
                .productName(productRequestBody.getProductName())
                .description(productRequestBody.getDescription())
                .price(productRequestBody.getPrice())
                .brandName(productRequestBody.getBrandName())
                .size(productRequestBody.getSize())
                .colour(productRequestBody.getColour())
                .build();
        productRepository.save(product);
        log.info("Product id {} is saved. ", product.getProductId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return  ProductResponse.builder()
                .productId(product.getProductId())
                .description(product.getDescription())
                .productName(product.getProductName())
                .brandName(product.getBrandName())
                .colour(product.getColour())
                .size(product.getSize())
                .price(product.getPrice())
                .build();
    }
}
