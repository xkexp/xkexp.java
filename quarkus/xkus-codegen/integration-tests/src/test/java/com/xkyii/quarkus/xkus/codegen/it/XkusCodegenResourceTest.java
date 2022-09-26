package com.xkyii.quarkus.xkus.codegen.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class XkusCodegenResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/xkus-codegen")
                .then()
                .statusCode(200)
                .body(is("Hello xkus-codegen"));
    }
}
