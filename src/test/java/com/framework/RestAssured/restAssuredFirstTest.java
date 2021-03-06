package com.framework.RestAssured;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class restAssuredFirstTest {

    @Test
    public void getStatusCode200(){
        RestAssured.get("https://api.github.com")
                .then()
                .statusCode(200);
    }

    @Test
    public void headersContainCorrectValues() {

        RestAssured.get("https://api.github.com")
                .then()
                .assertThat()
                .header("content-type","application/json; charset=utf-8")
                .header("X-Ratelimit-Limit", "60");
    }


    @Test
    public void bodyContainsCorrectValues() {

        RestAssured.get("https://api.github.com/users/Bong0202")
                .then()
                .assertThat()
                .body("login", equalTo("Bong0202"))
                .body("type", equalTo("User"));
    }

    @Test
    public void postFails() {

        RestAssured.post("https://api.github.com/user/repos")
                .then()
                .statusCode(401)
                .assertThat()
                // fails - incorrect usage
                .body(Matchers.contains("Requires authentication"));
    }

}
