package com.devconnect.kanban.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KanbanBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String status; // TODO: Could be enum (e.g., TODO, IN_PROGRESS, DONE)

    private String createdBy;
}
