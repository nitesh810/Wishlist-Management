package com.wishlistManagement.demo.Repository;

import com.wishlistManagement.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailId(String emailId);

}
