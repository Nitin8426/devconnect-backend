package com.devconnect.auth.repository;

import com.devconnect.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);          // already exists
    Optional<User> findByUsername(String username);    // 🔧 add this line
}
