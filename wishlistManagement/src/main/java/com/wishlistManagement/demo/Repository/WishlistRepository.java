package com.wishlistManagement.demo.Repository;

import com.wishlistManagement.demo.Model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
}
