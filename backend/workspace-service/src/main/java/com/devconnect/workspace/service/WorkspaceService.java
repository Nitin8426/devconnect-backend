package com.devconnect.workspace.service;

import com.devconnect.workspace.model.Workspace;
import com.devconnect.workspace.repository.WorkspaceRepository;
import com.devconnect.workspace.dto.WorkspaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WorkspaceService {

    @Autowired
    private WorkspaceRepository repo;

    public Workspace create(WorkspaceDTO dto) {
        Workspace w = new Workspace();
        w.setName(dto.name);
        w.setDescription(dto.description);

        if (dto.members != null) {
            List<UUID> ids = dto.members.stream().map(UUID::fromString).toList();
            w.setMembers(ids);
        }

        return repo.save(w);
    }

    public List<Workspace> getAllByUser(String userId) {
        return repo.findByMembersContains(UUID.fromString(userId));
    }

    public Workspace addMember(UUID workspaceId, UUID userId) {
        Workspace w = repo.findById(workspaceId)
                          .orElseThrow(() -> new RuntimeException("Not found"));
        if (!w.getMembers().contains(userId))
            w.getMembers().add(userId);
        return repo.save(w);
    }
}
