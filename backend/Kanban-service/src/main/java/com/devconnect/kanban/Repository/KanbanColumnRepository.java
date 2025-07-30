package com.devconnect.kanban.repository;

import com.devconnect.kanban.model.KanbanColumn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KanbanColumnRepository extends JpaRepository<KanbanColumn, Long> {
}
