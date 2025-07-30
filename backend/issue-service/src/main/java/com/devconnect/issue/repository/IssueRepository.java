package com.devconnect.issue.repository;

import com.devconnect.issue.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IssueRepository extends JpaRepository<Issue, UUID> {
    List<Issue> findByWorkspaceId(UUID workspaceId);
}
