package com.framework.JavaHttpClient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostTest {
    public static final String BASE_URL = "https://api.github.com/";

    @Test
    void PostWithoutAuthorization() throws IOException, InterruptedException {
        // Set up
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest post = HttpRequest.newBuilder(URI.create(BASE_URL + "user/repos"))
                .setHeader("credentials","")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        // Act
        HttpResponse<Void> response = client.send(post, HttpResponse.BodyHandlers.discarding());
        int actual_status_code = response.statusCode();

        // Assert
        Assertions.assertEquals(401, actual_status_code);
    }
}
