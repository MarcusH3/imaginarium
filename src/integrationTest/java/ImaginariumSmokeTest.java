import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ImaginariumSmokeTest {

    @BeforeAll
    public static void setUpClass() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void randomQuoteEndpointShouldReturnValidQuote() {
        given()
                .when()
                .get("/api/quotes/random")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }
    @Test
    public void fetchRandomImageEndpointShouldReturnValidImage() {
        given()
                .when()
                .get("/images/random")
                .then()
                .statusCode(200)
                .contentType(equalTo("image/jpeg"));
    }
}
