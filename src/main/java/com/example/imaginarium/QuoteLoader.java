package com.example.imaginarium;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**.
 * loads quotes from a file
 */

@Service
public class QuoteLoader {
  private QuoteFileService quoteData;
  /**.
   * load quotes from file
   */

  @PostConstruct
  public void loadQuotes() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    InputStream inputStream = new ClassPathResource("quote.json").getInputStream();
    this.quoteData = mapper.readValue(inputStream, QuoteFileService.class);
  }

  public List<String> getQuotes() {
    return quoteData.getQuotes();
  }
}
