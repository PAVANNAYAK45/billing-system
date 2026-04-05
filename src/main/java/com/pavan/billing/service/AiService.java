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

            // ✅ Proper JSON body (safe)
            String body = "{\n" +
                    "  \"model\": \"gpt-4o-mini\",\n" +
                    "  \"messages\": [\n" +
                    "    {\"role\": \"user\", \"content\": \"" + prompt + "\"}\n" +
                    "  ]\n" +
                    "}";

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + API_KEY);
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> request = new HttpEntity<>(body, headers);

            String response = restTemplate.postForObject(url, request, String.class);

            // ✅ Extract only useful text
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);

            return root
                    .path("choices")
                    .get(0)
                    .path("message")
                    .path("content")
                    .asText();

        } catch (Exception e) {
            return "AI summary not available";
        }
    }
}