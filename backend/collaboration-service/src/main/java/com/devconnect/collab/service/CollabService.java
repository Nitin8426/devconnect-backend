package com.devconnect.collab.service;

import com.devconnect.collab.dto.CollabSessionDTO;

import java.util.List;

public interface CollabService {
    CollabSessionDTO create(CollabSessionDTO dto);
    CollabSessionDTO update(Long id, CollabSessionDTO dto);
    void delete(Long id);
    CollabSessionDTO getById(Long id);
    List<CollabSessionDTO> getAll();
}