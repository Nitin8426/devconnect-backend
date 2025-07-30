// File: src/main/java/com/devconnect/user/repository/UserProfileRepository.java
package com.devconnect.user.repository;

import com.devconnect.user.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
