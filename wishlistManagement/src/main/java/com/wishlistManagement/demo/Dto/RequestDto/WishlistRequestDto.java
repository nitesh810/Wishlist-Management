package com.wishlistManagement.demo.Dto.RequestDto;

import com.wishlistManagement.demo.Enum.ProductCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class WishlistRequestDto {

    String emailId;

    String productName;

    ProductCategory category;
}
