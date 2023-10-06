package com.example.imaginarium;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class QuoteFileServiceTest {

  @InjectMocks
  private QuoteFileService quoteFileService;

  @Mock
  private List<String> mockQuotes;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);

    when(mockQuotes.size()).thenReturn(2);
    when(mockQuotes.get(0)).thenReturn("Quote 1");
    when(mockQuotes.get(1)).thenReturn("Quote 2");
  }

  @Test
  public void testGetQuotes() {
    List<String> quotes = quoteFileService.getQuotes();

    assertEquals(2, quotes.size());
    assertEquals("Quote 1", quotes.get(0));
    assertEquals("Quote 2", quotes.get(1));
  }
}
