package com.devconnect.workspace.controller;

import com.devconnect.workspace.dto.WorkspaceDTO;
import com.devconnect.workspace.model.Workspace;
import com.devconnect.workspace.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/workspaces")
public class WorkspaceController {

    @Autowired
    private WorkspaceService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody WorkspaceDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserWorkspaces(@PathVariable String userId) {
        return ResponseEntity.ok(service.getAllByUser(userId));
    }

    @PostMapping("/{workspaceId}/add-member/{userId}")
    public ResponseEntity<?> addMember(@PathVariable UUID workspaceId, @PathVariable UUID userId) {
        return ResponseEntity.ok(service.addMember(workspaceId, userId));
    }
}
