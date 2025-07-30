package com.devconnect.ai.service;

import com.devconnect.ai.dto.PromptResponse;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    public PromptResponse getResponse(String prompt) {
        // Mock GPT response (replace with real API logic if needed)
        String reply = "Mocked GPT reply to: " + prompt;
        return new PromptResponse(reply);
    }
}
