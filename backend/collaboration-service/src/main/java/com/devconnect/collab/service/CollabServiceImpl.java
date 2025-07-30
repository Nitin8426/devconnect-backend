package com.devconnect.collab.service.impl;

import com.devconnect.collab.dto.CollabSessionDTO;
import com.devconnect.collab.model.CollabSession;
import com.devconnect.collab.repository.CollabSessionRepository;
import com.devconnect.collab.service.CollabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollabServiceImpl implements CollabService {

    @Autowired
    private CollabSessionRepository repository;

    @Override
    public CollabSessionDTO create(CollabSessionDTO dto) {
        return CollabSessionDTO.fromEntity(repository.save(dto.toEntity()));
    }

    @Override
    public CollabSessionDTO update(Long id, CollabSessionDTO dto) {
        CollabSession entity = repository.findById(id).orElseThrow();
        entity.setSessionId(dto.getSessionId());
        entity.setDocumentName(dto.getDocumentName());
        entity.setCreatedBy(dto.getCreatedBy());
        return CollabSessionDTO.fromEntity(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CollabSessionDTO getById(Long id) {
        return repository.findById(id).map(CollabSessionDTO::fromEntity).orElseThrow();
    }

    @Override
    public List<CollabSessionDTO> getAll() {
        return repository.findAll().stream().map(CollabSessionDTO::fromEntity).collect(Collectors.toList());
    }
}
