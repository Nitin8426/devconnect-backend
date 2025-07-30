// src/main/java/com/devconnect/project/controller/ProjectController.java
package com.devconnect.project.controller;

import com.devconnect.project.dto.ProjectDTO;
import com.devconnect.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ProjectDTO create(@RequestBody ProjectDTO dto) {
        return projectService.createProject(dto);
    }

    @GetMapping
    public List<ProjectDTO> getAll() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectDTO getById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public ProjectDTO update(@PathVariable Long id, @RequestBody ProjectDTO dto) {
        return projectService.updateProject(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

    @GetMapping("/owner/{ownerId}")
    public List<ProjectDTO> getByOwner(@PathVariable String ownerId) {
        return projectService.getProjectsByOwner(ownerId);
    }
}
