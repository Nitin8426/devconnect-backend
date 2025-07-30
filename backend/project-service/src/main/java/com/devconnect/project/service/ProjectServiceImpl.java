// src/main/java/com/devconnect/project/service/ProjectServiceImpl.java
package com.devconnect.project.service;

import com.devconnect.project.dto.ProjectDTO;
import com.devconnect.project.model.Project;
import com.devconnect.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ProjectDTO createProject(ProjectDTO dto) {
        return ProjectDTO.fromEntity(projectRepository.save(ProjectDTO.toEntity(dto)));
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO dto) {
        Project project = projectRepository.findById(id).orElseThrow();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setOwnerId(dto.getOwnerId());
        return ProjectDTO.fromEntity(projectRepository.save(project));
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        return projectRepository.findById(id).map(ProjectDTO::fromEntity).orElseThrow();
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll().stream().map(ProjectDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> getProjectsByOwner(String ownerId) {
        return projectRepository.findByOwnerId(ownerId).stream().map(ProjectDTO::fromEntity).collect(Collectors.toList());
    }
}
