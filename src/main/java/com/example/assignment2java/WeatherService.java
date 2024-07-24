package com.example.assignment2java;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class WeatherService {
    private static final String API_KEY = "ad36cacddfc06915d398ca9ddc42d18b";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={API_KEY}";

    public Weather getWeather(String city) throws Exception {
        String url = API_URL.replace("{city}", city).replace("{API_KEY}", API_KEY);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            return gson.fromJson(response.body(), Weather.class);
        } else {
            throw new Exception("Error fetching weather data: " + response.body());
        }
    }
}
