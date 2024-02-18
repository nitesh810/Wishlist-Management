package com.wishlistManagement.demo.Controller;

import com.wishlistManagement.demo.Dto.RequestDto.UserRequestDto;
import com.wishlistManagement.demo.Dto.ResponseDto.UserResponseDto;
import com.wishlistManagement.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    public ResponseEntity addUser(@RequestBody UserRequestDto userRequestDto) {

        try {
            UserResponseDto userResponseDto = userService.addUser(userRequestDto);
            return new ResponseEntity<>(userResponseDto, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
