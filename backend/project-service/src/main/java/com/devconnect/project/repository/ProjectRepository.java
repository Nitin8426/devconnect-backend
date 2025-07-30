// src/main/java/com/devconnect/project/repository/ProjectRepository.java
package com.devconnect.project.repository;

import com.devconnect.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByOwnerId(String ownerId);
}
