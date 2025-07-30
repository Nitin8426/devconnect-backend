package com.devconnect.collab.repository;

import com.devconnect.collab.model.CollabSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollabSessionRepository extends JpaRepository<CollabSession, Long> {
}