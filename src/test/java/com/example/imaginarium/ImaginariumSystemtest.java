package com.example.imaginarium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class ImaginariumSystemtest {

    private static RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080";

    @BeforeAll
    public static void setup() {
        restTemplate = new RestTemplateBuilder().build();
    }

    @Test
    public void testFetchRandomImage() {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/images/random", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.hasBody(), "Image not returned");
    }

    @Test
    public void testFetchRandomQuote() {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/api/quotes/random", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody(), "Quote not returned");
        assertFalse(response.getBody().isEmpty(), "Quote is empty");
    }


    @AfterAll
    public static void tearDown() {
    }
}
