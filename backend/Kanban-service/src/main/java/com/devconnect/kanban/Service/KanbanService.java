package com.devconnect.kanban.service;

import com.devconnect.kanban.dto.KanbanColumnDTO;

import java.util.List;

public interface KanbanService {
    List<KanbanColumnDTO> getAllColumns();
    KanbanColumnDTO createColumn(KanbanColumnDTO columnDTO);
    KanbanColumnDTO updateColumn(Long id, KanbanColumnDTO columnDTO);
    void deleteColumn(Long id);
}
