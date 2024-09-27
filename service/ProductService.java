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

    public ProductResponse createProduct(ProductRequest productRequestBody) {

        Product product = Product.builder()
                .productName(productRequestBody.productName())
                .description(productRequestBody.description())
                .startingPrice(productRequestBody.startingPrice())
                .brandName(productRequestBody.brandName())
                .size(productRequestBody.size())
                .colour(productRequestBody.colour())
                .build();
        productRepository.save(product);
        log.info("Product with id {} is saved. ", product.getProductId());
        return  new ProductResponse(product.getProductId(), product.getProductName(), product.getBrandName(), product.getDescription(), product.getStartingPrice(), product.getSize(), product.getColour());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getProductId(), product.getProductName(), product.getBrandName(), product.getDescription(), product.getStartingPrice(), product.getSize(), product.getColour()))
                .toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return  ProductResponse.builder()
                .productId(product.getProductId())
                .description(product.getDescription())
                .productName(product.getProductName())
                .brandName(product.getBrandName())
                .colour(product.getColour())
                .size(product.getSize())
                .startingPrice(product.getStartingPrice())
                .build();
    }
}
