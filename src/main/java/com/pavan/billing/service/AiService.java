package com.pavan.billing.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AiService {

    private final WebClient webClient;

    public AiService() {
        this.webClient = WebClient.create("https://api.openai.com/v1");
    }

    public String generateSummary(String prompt) {

        String apiKey = "YOUR_API_KEY";

        String requestBody = """
        {
          "model": "gpt-4.1-mini",
          "messages": [
            {"role": "user", "content": "%s"}
          ]
        }
        """.formatted(prompt);

        return webClient.post()
                .uri("/chat/completions")
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}