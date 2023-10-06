package com.example.imaginarium;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.List;

@Service
public class QuoteLoader {

    private List<String> quotes;

    @PostConstruct
    public void loadQuotes() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("quote.json").getInputStream();
        QuoteData quoteData = mapper.readValue(inputStream, QuoteData.class);
        this.quotes = quoteData.getQuotes();
    }

    public List<String> getQuotes() {
        return quotes;
    }
}
