package com.devconnect.editor.controller;

import com.devconnect.editor.model.CRDTDocument;
import com.devconnect.editor.service.EditorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/editor")
public class EditorController {

    private final EditorService editorService;

    public EditorController(EditorService editorService) {
        this.editorService = editorService;
    }

    @GetMapping("/{docId}")
    public CRDTDocument getDocument(@PathVariable String docId) {
        return editorService.getDocument(docId);
    }

    @PostMapping("/{docId}")
    public void updateDocument(@PathVariable String docId, @RequestBody CRDTDocument doc) {
        editorService.updateDocument(docId, doc.getContent());
    }
}
