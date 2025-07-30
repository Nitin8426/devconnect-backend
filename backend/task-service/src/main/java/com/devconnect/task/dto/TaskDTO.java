package com.devconnect.task.dto;

import com.devconnect.task.model.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private String status;

    public static TaskDTO fromEntity(TaskEntity entity) {
        return TaskDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .build();
    }

    public TaskEntity toEntity() {
        return new TaskEntity(this.title, this.description, this.status);
    }
}
