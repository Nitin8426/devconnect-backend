package com.devconnect.issue.service;

import com.devconnect.issue.dto.CommentDTO;
import com.devconnect.issue.dto.IssueDTO;
import com.devconnect.issue.model.Comment;
import com.devconnect.issue.model.Issue;
import com.devconnect.issue.repository.CommentRepository;
import com.devconnect.issue.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IssueService {

    @Autowired private IssueRepository issueRepo;
    @Autowired private CommentRepository commentRepo;

    public Issue create(IssueDTO dto) {
        Issue i = new Issue();
        i.setTitle(dto.title);
        i.setDescription(dto.description);
        i.setStatus(dto.status != null ? dto.status : "open");
        i.setWorkspaceId(dto.workspaceId);
        i.setAssignedTo(dto.assignedTo);
        return issueRepo.save(i);
    }

    public List<Issue> getByWorkspace(UUID workspaceId) {
        return issueRepo.findByWorkspaceId(workspaceId);
    }

    public Comment addComment(UUID issueId, CommentDTO dto) {
        Issue issue = issueRepo.findById(issueId).orElseThrow();
        Comment c = new Comment();
        c.setContent(dto.content);
        c.setAuthorId(UUID.fromString(dto.authorId));
        c.setIssue(issue);
        return commentRepo.save(c);
    }

    public Issue updateStatus(UUID issueId, String newStatus) {
        Issue i = issueRepo.findById(issueId).orElseThrow();
        i.setStatus(newStatus);
        return issueRepo.save(i);
    }
}
