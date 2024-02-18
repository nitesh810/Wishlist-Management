package com.wishlistManagement.demo.Service;

import com.wishlistManagement.demo.Dto.RequestDto.UserRequestDto;
import com.wishlistManagement.demo.Dto.ResponseDto.UserResponseDto;
import com.wishlistManagement.demo.Dto.ResponseDto.WishlistResponseDto;
import com.wishlistManagement.demo.Exception.UserNotFoundException;
import com.wishlistManagement.demo.Model.User;
import com.wishlistManagement.demo.Repository.UserRepository;
import com.wishlistManagement.demo.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponseDto addUser(UserRequestDto userRequestDto) {

        User user = UserTransformer.userRequestDtoToUser(userRequestDto);

        userRepository.save(user);

        UserResponseDto userResponseDto = UserTransformer.userToUserResponseDto(user);

        return userResponseDto;
    }
}
