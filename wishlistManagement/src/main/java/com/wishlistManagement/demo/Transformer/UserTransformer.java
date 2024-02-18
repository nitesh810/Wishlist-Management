package com.wishlistManagement.demo.Transformer;

import com.wishlistManagement.demo.Dto.RequestDto.UserRequestDto;
import com.wishlistManagement.demo.Dto.ResponseDto.UserResponseDto;
import com.wishlistManagement.demo.Model.User;

public class UserTransformer {

    public static User userRequestDtoToUser(UserRequestDto userRequestDto) {

        return User.builder()
                .name(userRequestDto.getName())
                .emailId(userRequestDto.getEmailId())
                .gender(userRequestDto.getGender())
                .mobNo(userRequestDto.getMobNo())
                .build();
    }

    public static UserResponseDto userToUserResponseDto(User user) {

        return UserResponseDto.builder()
                .name(user.getName())
                .mobNo(user.getMobNo())
                .emailId(user.getEmailId())
                .gender(user.getGender())
                .build();
    }
}
