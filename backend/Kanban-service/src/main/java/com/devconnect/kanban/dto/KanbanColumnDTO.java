package com.devconnect.kanban.dto;

import com.devconnect.kanban.model.KanbanColumn;

public class KanbanColumnDTO {

    private Long id;
    private String title;
    private Integer position;

    public static KanbanColumnDTO fromEntity(KanbanColumn column) {
        KanbanColumnDTO dto = new KanbanColumnDTO();
        dto.setId(column.getId());
        dto.setTitle(column.getTitle());
        dto.setPosition(column.getPosition());
        return dto;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
