// File: src/main/java/com/devconnect/user/dto/UserProfileDTO.java
package com.devconnect.user.dto;

import com.devconnect.user.model.UserProfile;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileDTO {
    private Long id;
    private String username;
    private String email;
    private String bio;
    private String avatarUrl;

    public static UserProfileDTO fromEntity(UserProfile user) {
        return UserProfileDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .bio(user.getBio())
                .avatarUrl(user.getAvatarUrl())
                .build();
    }

    public static UserProfile toEntity(UserProfileDTO dto) {
        return UserProfile.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .bio(dto.getBio())
                .avatarUrl(dto.getAvatarUrl())
                .build();
    }
}
