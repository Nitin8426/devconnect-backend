package com.devconnect.issue.controller;

import com.devconnect.issue.dto.CommentDTO;
import com.devconnect.issue.dto.IssueDTO;
import com.devconnect.issue.model.Comment;
import com.devconnect.issue.model.Issue;
import com.devconnect.issue.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    private IssueService service;

    @PostMapping
    public ResponseEntity<Issue> create(@RequestBody IssueDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/workspace/{workspaceId}")
    public ResponseEntity<List<Issue>> getByWorkspace(@PathVariable UUID workspaceId) {
        return ResponseEntity.ok(service.getByWorkspace(workspaceId));
    }

    @PostMapping("/{issueId}/comment")
    public ResponseEntity<Comment> comment(@PathVariable UUID issueId, @RequestBody CommentDTO dto) {
        return ResponseEntity.ok(service.addComment(issueId, dto));
    }

    @PatchMapping("/{issueId}/status/{status}")
    public ResponseEntity<Issue> updateStatus(@PathVariable UUID issueId, @PathVariable String status) {
        return ResponseEntity.ok(service.updateStatus(issueId, status));
    }
}
