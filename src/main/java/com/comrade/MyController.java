package com.comrade;

import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MyController {

   private final EmbeddingClient embeddingClient;

    public MyController(EmbeddingClient embeddingClient) {
        this.embeddingClient = embeddingClient;
    }

    @GetMapping("/ai/embedding")
    public Map embed(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        EmbeddingResponse embeddingResponse = this.embeddingClient.embedForResponse(List.of(message));
        return Map.of("embedding", embeddingResponse);
    }
}
