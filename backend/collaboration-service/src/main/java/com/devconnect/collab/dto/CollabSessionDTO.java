package com.devconnect.collab.dto;

import com.devconnect.collab.model.CollabSession;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollabSessionDTO {
    private Long id;
    private String sessionId;
    private String documentName;
    private String createdBy;

    public static CollabSessionDTO fromEntity(CollabSession entity) {
        return CollabSessionDTO.builder()
                .id(entity.getId())
                .sessionId(entity.getSessionId())
                .documentName(entity.getDocumentName())
                .createdBy(entity.getCreatedBy())
                .build();
    }

    public CollabSession toEntity() {
        return CollabSession.builder()
                .id(id)
                .sessionId(sessionId)
                .documentName(documentName)
                .createdBy(createdBy)
                .build();
    }
}
