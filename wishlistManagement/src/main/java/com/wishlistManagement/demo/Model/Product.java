package com.wishlistManagement.demo.Model;

import com.wishlistManagement.demo.Enum.ProductCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="product")
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String productName;

    @Enumerated(EnumType.STRING)
    ProductCategory category;

    @ManyToOne
    @JoinColumn
    Wishlist wishlist;

}