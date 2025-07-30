package com.devconnect.kanban.service.impl;

import com.devconnect.kanban.dto.KanbanColumnDTO;
import com.devconnect.kanban.model.KanbanColumn;
import com.devconnect.kanban.repository.KanbanColumnRepository;
import com.devconnect.kanban.service.KanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KanbanServiceImpl implements KanbanService {

    @Autowired
    private KanbanColumnRepository repository;

    @Override
    public KanbanColumnDTO createColumn(KanbanColumnDTO dto) {
        KanbanColumn column = new KanbanColumn();
        column.setTitle(dto.getTitle());
        column.setPosition(dto.getPosition());
        return KanbanColumnDTO.fromEntity(repository.save(column));
    }

    @Override
    public KanbanColumnDTO updateColumn(Long id, KanbanColumnDTO dto) {
        KanbanColumn column = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Column not found"));
        column.setTitle(dto.getTitle());
        column.setPosition(dto.getPosition());
        return KanbanColumnDTO.fromEntity(repository.save(column));
    }

    @Override
    public void deleteColumn(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<KanbanColumnDTO> getAllColumns() {
        return repository.findAll().stream()
                .map(KanbanColumnDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
