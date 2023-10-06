package com.example.imaginarium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
public class QuoteService {

    private final QuoteLoader quoteLoader;
    private final Random random = new Random();

    @Autowired
    public QuoteService(QuoteLoader quoteLoader) {
        this.quoteLoader = quoteLoader;
    }

    public String getRandomQuote() {
        List<String> quotes = quoteLoader.getQuotes();

        if (quotes == null || quotes.isEmpty()) {
            return "No quotes available";
        }

        int randomIndex = random.nextInt(quotes.size());
        return quotes.get(randomIndex);
    }
}