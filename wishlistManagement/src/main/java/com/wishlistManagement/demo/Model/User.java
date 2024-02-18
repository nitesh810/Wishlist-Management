package com.wishlistManagement.demo.Model;

import com.wishlistManagement.demo.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(unique = true)
    String emailId;

    @Column(unique = true)
    String mobNo;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne
    @JoinColumn
    Wishlist wishlist;
}