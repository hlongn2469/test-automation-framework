package com.framework.JavaHttpClient;

import com.testframework.entities.User;
import com.testframework.handlers.JsonBodyHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetBodyTest {
    public static final String BASE_URL = "https://api.github.com/";

    @Test
    void bodyContainsCurrentUserURL() throws IOException, InterruptedException {
        // Set up
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL + "users/Bong0202"))
                .GET().setHeader("User-client", "bot")
                .build();
        // Act
        HttpResponse<String> response = client.send(get, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        // Assert
        Assertions.assertTrue((body.contains("\"login\":\"Bong0202\"")));
    }

    @Test
    void handleJsonBody() throws IOException, InterruptedException {
        // Set up
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL + "users/Bong0202"))
                .GET().setHeader("User-client", "bot")
                .build();
        // Act
        HttpResponse<User> response = client.send(get, JsonBodyHandler.jsonBodyHandler(User.class));
        String actual_login = response.body().getLogin();

        // Assert
        Assertions.assertEquals("Bong0202", actual_login);
    }

}
