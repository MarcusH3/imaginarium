import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


/**.
    * ImaginariumSystemtest
    */
public class ImaginariumSystemtest {

  private static RestTemplate restTemplate;
  private final String baseUrl = "http://localhost:8080";

  @BeforeAll
  public static void setup() {
    restTemplate = new RestTemplateBuilder().build();
  }

  @Test
  public void testFetchRandomImage() {
    ResponseEntity<String> response =
        restTemplate.getForEntity(baseUrl + "/images/random", String.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertTrue(response.hasBody(), "Image not returned");
  }

  @Test
  public void testFetchRandomQuote() {
    ResponseEntity<String> response =
        restTemplate.getForEntity(baseUrl + "/api/quotes/random", String.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody(), "Quote not returned");
    assertFalse(response.getBody().isEmpty(), "Quote is empty");
  }

  @AfterAll
  public static void tearDown() {
  }
}
