package com.wishlistManagement.demo.Transformer;

import com.wishlistManagement.demo.Dto.RequestDto.WishlistRequestDto;
import com.wishlistManagement.demo.Dto.ResponseDto.ProductResponseDto;
import com.wishlistManagement.demo.Dto.ResponseDto.UserResponseDto;
import com.wishlistManagement.demo.Dto.ResponseDto.WishlistResponseDto;
import com.wishlistManagement.demo.Model.Product;
import com.wishlistManagement.demo.Model.User;
import com.wishlistManagement.demo.Model.Wishlist;

import java.util.ArrayList;
import java.util.List;

public class WishlistTransformer {

    public static WishlistResponseDto WishlistToWishlistResponseDto(Wishlist wishlist) {

        User user = wishlist.getUser();
        UserResponseDto userResponseDto = UserTransformer.userToUserResponseDto(user);

        List<Product> orgProducts = wishlist.getProducts();

        List<ProductResponseDto> products = new ArrayList<>();

        for(int i=0; i<orgProducts.size(); i++) {
            Product product = orgProducts.get(i);
            ProductResponseDto productResponseDto = ProductTransformer.productToProductResponseDto(product);
            products.add(productResponseDto);
        }

        return WishlistResponseDto.builder()
                .userResponseDto(userResponseDto)
                .products(products)
                .build();
    }
}
