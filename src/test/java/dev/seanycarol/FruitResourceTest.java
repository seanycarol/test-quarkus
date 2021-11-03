package dev.seanycarol;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(FruitResource.class)
public class FruitResourceTest {

    @Test
    public void testListFruits() {
        given().when().get().then().statusCode(200).body(is(
                "[{\"id\":1,\"name\":\"Maçã\",\"quantity\":5},{\"id\":2,\"name\":\"Uva\",\"quantity\":3},{\"id\":3,\"name\":\"Laranja\",\"quantity\":4}]"));
    }
}