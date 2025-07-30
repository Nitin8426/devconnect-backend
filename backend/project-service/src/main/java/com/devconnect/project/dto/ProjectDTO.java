// src/main/java/com/devconnect/project/dto/ProjectDTO.java
package com.devconnect.project.dto;

import com.devconnect.project.model.Project;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDTO {

    private Long id;
    private String name;
    private String description;
    private String ownerId;

    public static ProjectDTO fromEntity(Project project) {
        return ProjectDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .ownerId(project.getOwnerId())
                .build();
    }

    public static Project toEntity(ProjectDTO dto) {
        return Project.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .ownerId(dto.getOwnerId())
                .build();
    }
}
