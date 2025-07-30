// src/main/java/com/devconnect/project/service/ProjectService.java
package com.devconnect.project.service;

import com.devconnect.project.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    ProjectDTO createProject(ProjectDTO dto);
    ProjectDTO updateProject(Long id, ProjectDTO dto);
    void deleteProject(Long id);
    ProjectDTO getProjectById(Long id);
    List<ProjectDTO> getAllProjects();
    List<ProjectDTO> getProjectsByOwner(String ownerId);
}
