// File: src/main/java/com/devconnect/user/service/UserProfileServiceImpl.java
package com.devconnect.user.service;

import com.devconnect.user.dto.UserProfileDTO;
import com.devconnect.user.model.UserProfile;
import com.devconnect.user.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository repository;

    @Override
    public UserProfileDTO createUser(UserProfileDTO dto) {
        UserProfile user = UserProfileDTO.toEntity(dto);
        return UserProfileDTO.fromEntity(repository.save(user));
    }

    @Override
    public UserProfileDTO getUserById(Long id) {
        return repository.findById(id)
                .map(UserProfileDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserProfileDTO> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(UserProfileDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserProfileDTO updateUser(Long id, UserProfileDTO dto) {
        UserProfile user = repository.findById(id).orElseThrow();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setBio(dto.getBio());
        user.setAvatarUrl(dto.getAvatarUrl());
        return UserProfileDTO.fromEntity(repository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
