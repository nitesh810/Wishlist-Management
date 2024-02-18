package com.wishlistManagement.demo.Dto.ResponseDto;

import com.wishlistManagement.demo.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserResponseDto {

    String name;

    String emailId;

    String mobNo;

    Gender gender;
}
