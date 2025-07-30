package com.devconnect.issue.dto;

import java.util.UUID;

public class IssueDTO {
    public String title;
    public String description;
    public String status;
    public UUID workspaceId;
    public UUID assignedTo;
}
