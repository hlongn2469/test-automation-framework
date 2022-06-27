package com.framework.JavaHttpClient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetHeaderTest {
    public static final String BASE_URL = "https://api.github.com";

    @Test
    void getReturns200() throws IOException, InterruptedException {
        // Set up
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .GET().setHeader("User-client", "bot")
                .build();
        // Act
        HttpResponse<Void> response = client.send(get, HttpResponse.BodyHandlers.discarding());
        int actual_status_code = response.statusCode();

        // Assert
        Assertions.assertEquals(200, actual_status_code);
    }

    @Test
    void contentTypeIsJson() throws IOException, InterruptedException {
        // Set up
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .GET().setHeader("User-client", "bot")
                .build();
        // Act
        HttpResponse<Void> response = client.send(get, HttpResponse.BodyHandlers.discarding());
        String content_type = response.headers().firstValue("content-type").get();

        // Assert
        Assertions.assertEquals("application/json; charset=utf-8", content_type);
    }

    @Test
    void xRateLimitIsPresent() throws IOException, InterruptedException {
        // Set up
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .GET().setHeader("User-client", "bot")
                .build();
        // Act
        HttpResponse<Void> response = client.send(get, HttpResponse.BodyHandlers.discarding());
        String x_rate_limit = response.headers().firstValue("X-Ratelimit-Limit").get();

        // Assert
        Assertions.assertEquals(60, Integer.parseInt(x_rate_limit));
    }

}
