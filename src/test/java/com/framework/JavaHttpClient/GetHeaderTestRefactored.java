package com.framework.JavaHttpClient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetHeaderTestRefactored {
    public static final String BASE_URL = "https://api.github.com";
    static HttpClient client = HttpClient.newBuilder().build();
    static HttpResponse<Void> response;

    @BeforeAll
    static void sendgetToBaseEndpoint() throws IOException, InterruptedException{
        // Set up
        client = HttpClient.newBuilder().build();

        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .GET().setHeader("User-client", "bot")
                .build();
        // Act
        response = client.send(get, HttpResponse.BodyHandlers.discarding());
    }

    @Test
    void getReturns200() throws IOException, InterruptedException {

        int actual_status_code = response.statusCode();

        // Assert
        Assertions.assertEquals(200, actual_status_code);
    }

    @ParameterizedTest
    @CsvSource({
            "X-Ratelimit-Limit, 60",
            "content-type,application/json; charset=utf-8",
            "server, GitHub.com",
            "x-frame-options, deny"
    })
    void ParameterizedTestHeaders(String input_header, String expected_value) throws IOException, InterruptedException {
        String content_type = response.headers().firstValue(input_header).get();
        // Assert
        Assertions.assertEquals(expected_value, content_type);
    }
}
