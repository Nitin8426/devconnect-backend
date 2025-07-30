package com.devconnect.kanban.controller;

import com.devconnect.kanban.dto.KanbanColumnDTO;
import com.devconnect.kanban.service.KanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kanban")
public class KanbanController {

    @Autowired
    private KanbanService kanbanService;

    @GetMapping("/columns")
    public List<KanbanColumnDTO> getAllColumns() {
        return kanbanService.getAllColumns();
    }

    @PostMapping("/columns")
    public KanbanColumnDTO createColumn(@RequestBody KanbanColumnDTO columnDTO) {
        return kanbanService.createColumn(columnDTO);
    }

    @PutMapping("/columns/{id}")
    public KanbanColumnDTO updateColumn(@PathVariable Long id, @RequestBody KanbanColumnDTO columnDTO) {
        return kanbanService.updateColumn(id, columnDTO);
    }

    @DeleteMapping("/columns/{id}")
    public void deleteColumn(@PathVariable Long id) {
        kanbanService.deleteColumn(id);
    }
}
