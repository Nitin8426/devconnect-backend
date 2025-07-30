package com.devconnect.ai.controller;

import com.devconnect.ai.dto.PromptRequest;
import com.devconnect.ai.dto.PromptResponse;
import com.devconnect.ai.service.AiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/generate")
    public PromptResponse generateText(@RequestBody PromptRequest request) {
        return aiService.getResponse(request.getPrompt());
    }
}
