package com.wishlistManagement.demo.Dto.ResponseDto;

import com.wishlistManagement.demo.Enum.ProductCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {

    String productName;

    ProductCategory category;
}
