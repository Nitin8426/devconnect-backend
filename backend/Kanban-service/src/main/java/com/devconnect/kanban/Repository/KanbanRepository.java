package com.devconnect.kanban.repository;

import com.devconnect.kanban.model.KanbanBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KanbanRepository extends JpaRepository<KanbanBoard, Long> {
    List<KanbanBoard> findByCreatedBy(String createdBy);
}
