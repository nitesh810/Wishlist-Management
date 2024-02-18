package com.wishlistManagement.demo.Controller;

import com.wishlistManagement.demo.Dto.RequestDto.WishlistRequestDto;
import com.wishlistManagement.demo.Dto.ResponseDto.WishlistResponseDto;
import com.wishlistManagement.demo.Model.User;
import com.wishlistManagement.demo.Model.Wishlist;
import com.wishlistManagement.demo.Service.UserService;
import com.wishlistManagement.demo.Service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    WishlistService wishlistService;

    @GetMapping("/api/get")
    public ResponseEntity getWishlist(@RequestBody String emailId) {

        try {
            WishlistResponseDto wishlistResponseDto = wishlistService.getWishlist(emailId);
            return new ResponseEntity<>(wishlistResponseDto, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/add")
    public ResponseEntity addWishlist(@RequestBody WishlistRequestDto wishlistRequestDto) {

        try {
            String message = wishlistService.addWishlist(wishlistRequestDto);
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteItem")
    public ResponseEntity deleteWishlist(@RequestParam("userId") int userId, @RequestParam("proId") int proId) {

        try {
            String message = wishlistService.deleteWishlistItem(userId, proId);
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
