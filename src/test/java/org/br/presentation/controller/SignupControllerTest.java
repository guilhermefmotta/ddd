package org.br.presentation.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class SignupControllerTest {

    @Test
    public void shouldReturn400IfNoNameisProvided() {
        given()
                .when().get("/signup")
                .then()
                .statusCode(400)
                .body(is("{email: 'any_email}"));
    }

}