package com.example.imaginarium;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuoteLoaderTest {

  private QuoteLoader quoteLoader;

  @BeforeEach
  void setUp() throws Exception {
    quoteLoader = new QuoteLoader();

    quoteLoader.loadQuotes();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void loadQuotes() {
    List<String> quotes = quoteLoader.getQuotes();

    assertNotNull(quotes, "Quotes should be loaded");
    assertFalse(quotes.isEmpty(), "Quotes should not be empty after loading");
  }

  @Test
  void getQuotes() {
    List<String> quotes = quoteLoader.getQuotes();

    assertNotNull(quotes, "Quotes should not be null");
    assertFalse(quotes.isEmpty(), "Quotes should not be empty");

    String exampleQuote = "si";
    assertTrue(quotes.contains(exampleQuote), "Expected quote not found");
  }
}
