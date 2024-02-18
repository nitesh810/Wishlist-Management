package com.wishlistManagement.demo.Dto.RequestDto;

import com.wishlistManagement.demo.Enum.Gender;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserRequestDto {

    String name;

    String emailId;

    String mobNo;

    Gender gender;
}
