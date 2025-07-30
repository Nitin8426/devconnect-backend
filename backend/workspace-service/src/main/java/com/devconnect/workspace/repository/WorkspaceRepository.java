package com.devconnect.workspace.repository;

import com.devconnect.workspace.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface WorkspaceRepository extends JpaRepository<Workspace, UUID> {
    List<Workspace> findByMembersContains(UUID memberId);
}
