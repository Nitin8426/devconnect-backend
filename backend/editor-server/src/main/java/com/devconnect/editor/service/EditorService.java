package com.devconnect.editor.service;

import com.devconnect.editor.model.CRDTDocument;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class EditorService {
    private final ConcurrentHashMap<String, CRDTDocument> documentStore = new ConcurrentHashMap<>();

    public CRDTDocument getDocument(String docId) {
        return documentStore.getOrDefault(docId, new CRDTDocument(docId, ""));
    }

    public void updateDocument(String docId, String content) {
        documentStore.put(docId, new CRDTDocument(docId, content));
    }
}
