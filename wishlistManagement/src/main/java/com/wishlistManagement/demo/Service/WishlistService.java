package com.wishlistManagement.demo.Service;

import com.wishlistManagement.demo.Dto.RequestDto.WishlistRequestDto;
import com.wishlistManagement.demo.Dto.ResponseDto.ProductResponseDto;
import com.wishlistManagement.demo.Dto.ResponseDto.WishlistResponseDto;
import com.wishlistManagement.demo.Exception.NoProductAvailableException;
import com.wishlistManagement.demo.Exception.UserNotFoundException;
import com.wishlistManagement.demo.Model.Product;
import com.wishlistManagement.demo.Model.User;
import com.wishlistManagement.demo.Model.Wishlist;
import com.wishlistManagement.demo.Repository.UserRepository;
import com.wishlistManagement.demo.Repository.WishlistRepository;
import com.wishlistManagement.demo.Transformer.WishlistTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class WishlistService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WishlistRepository wishlistRepository;

    public WishlistResponseDto getWishlist(String emailId) {

        User user = userRepository.findByEmailId(emailId);

        if(user == null) {
            throw new UserNotFoundException("user not exist's");
        }

        Wishlist wishlist = user.getWishlist();

        WishlistResponseDto wishlistResponseDto = WishlistTransformer.WishlistToWishlistResponseDto(wishlist);

        List<ProductResponseDto> products = wishlistResponseDto.getProducts();
        if(products.size() == 0) {
            throw new NoProductAvailableException("No Product Available");
        }

        return wishlistResponseDto;
    }

    public String addWishlist(WishlistRequestDto wishlistRequestDto) {

        User user = userRepository.findByEmailId(wishlistRequestDto.getEmailId());

        if(user == null) {
            throw new UserNotFoundException("user not exist's");
        }

        List<Product> products = user.getWishlist().getProducts();

        Product product = Product.builder()
                .productName(wishlistRequestDto.getProductName())
                .category(wishlistRequestDto.getCategory())
                .build();

        products.add(product);

        Wishlist wishlist = Wishlist.builder()
                .products(products)
                .user(user)
                .build();

        wishlistRepository.save(wishlist);

        user.setWishlist(wishlist);

        userRepository.save(user);

        return "Product added on your wishlist";
    }

    public String deleteWishlistItem(int userId, int proId) {

        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("user not exist's");
        }

        User user = optionalUser.get();

        Wishlist wishlist = user.getWishlist();

        List<Product> products = wishlist.getProducts();

        for(int i=0; i<products.size(); i++) {
            Product product = products.get(i);
            if(product.getId() == proId) {
                products.remove(i);
                wishlistRepository.save(wishlist);
                return "your wishlist item got deleted";
            }
        }

        return "product not available on your wishlist";
    }
}
