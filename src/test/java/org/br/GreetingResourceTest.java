package org.br;

import io.quarkus.test.junit.QuarkusTest;
import org.br.presentation.controller.SignupController;
import org.br.presentation.data.Signup;
import org.br.presentation.protocols.HttpRequest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Inject
    private SignupController signupController;

    @Test
    public void testHelloEndpoint() throws NoSuchFieldException, IllegalAccessException {
        Signup a = new Signup("123", "123", "may");
        signupController.handle(new HttpRequest<>(a));
    }

}