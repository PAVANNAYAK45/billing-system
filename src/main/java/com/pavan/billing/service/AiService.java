package com.pavan.billing.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AiService {

    private final String API_KEY = System.getenv("OPENAI_API_KEY");

   public String generateSummary(String prompt) {
    try {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.openai.com/v1/chat/completions";

        String body = "{\n" +
                "  \"model\": \"gpt-4o-mini\",\n" +
                "  \"messages\": [\n" +
                "    {\"role\": \"user\", \"content\": \"" + prompt + "\"}\n" +
                "  ],\n" +
                "  \"temperature\": 0.7\n" +
                "}";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity(url, request, String.class);

        String response = responseEntity.getBody();

        // 🔥 DEBUG (don’t remove yet)
        System.out.println("FULL AI RESPONSE: " + response);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response);

        JsonNode choices = root.path("choices");

        if (choices.isEmpty()) {
            return "AI response empty";
        }

        return choices.get(0)
                .path("message")
                .path("content")
                .asText();

    } catch (Exception e) {
        e.printStackTrace(); // 🔥 VERY IMPORTANT
        return "AI summary not available";
    }
}
}