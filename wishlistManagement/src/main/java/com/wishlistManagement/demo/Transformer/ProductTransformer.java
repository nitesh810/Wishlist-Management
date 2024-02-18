package com.wishlistManagement.demo.Transformer;

import com.wishlistManagement.demo.Dto.RequestDto.ProductRequestDto;
import com.wishlistManagement.demo.Dto.ResponseDto.ProductResponseDto;
import com.wishlistManagement.demo.Model.Product;

public class ProductTransformer {

    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto) {

        return Product.builder()
                .productName(productRequestDto.getProductName())
                .category(productRequestDto.getCategory())
                .build();
    }

    public static ProductResponseDto productToProductResponseDto(Product product) {

        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .category(product.getCategory())
                .build();
    }
}
