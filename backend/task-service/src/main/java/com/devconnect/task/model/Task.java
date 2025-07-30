package com.devconnect.task.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String status; // TODO, IN_PROGRESS, DONE

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long kanbanColumnId; // Foreign key reference
}
