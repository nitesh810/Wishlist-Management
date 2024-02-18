package com.wishlistManagement.demo.Dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class WishlistResponseDto {

    UserResponseDto userResponseDto;

    List<ProductResponseDto> products = new ArrayList<>();
}
