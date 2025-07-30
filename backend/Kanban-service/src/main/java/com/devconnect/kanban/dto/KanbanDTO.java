package com.devconnect.kanban.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KanbanDTO {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String createdBy;
}
