package com.devconnect.collab.controller;

import com.devconnect.collab.dto.CollabSessionDTO;
import com.devconnect.collab.service.CollabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collab")
@CrossOrigin(origins = "*")
public class CollabController {

    @Autowired
    private CollabService service;

    @PostMapping
    public CollabSessionDTO create(@RequestBody CollabSessionDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public CollabSessionDTO update(@PathVariable Long id, @RequestBody CollabSessionDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping("/{id}")
    public CollabSessionDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<CollabSessionDTO> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}