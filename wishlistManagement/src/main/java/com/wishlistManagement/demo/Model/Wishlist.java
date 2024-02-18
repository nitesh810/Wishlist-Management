package com.wishlistManagement.demo.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name="wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToMany(mappedBy = "wishlist",cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();

    @OneToOne(mappedBy = "wishlist",cascade = CascadeType.ALL)
    User user;

}
