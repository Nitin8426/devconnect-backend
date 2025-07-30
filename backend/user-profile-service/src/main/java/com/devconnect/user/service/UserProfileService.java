// File: src/main/java/com/devconnect/user/service/UserProfileService.java
package com.devconnect.user.service;

import com.devconnect.user.dto.UserProfileDTO;

import java.util.List;

public interface UserProfileService {
    UserProfileDTO createUser(UserProfileDTO dto);
    UserProfileDTO getUserById(Long id);
    List<UserProfileDTO> getAllUsers();
    UserProfileDTO updateUser(Long id, UserProfileDTO dto);
    void deleteUser(Long id);
}
