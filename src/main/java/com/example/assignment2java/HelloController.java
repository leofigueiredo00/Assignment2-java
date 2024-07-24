package com.example.assignment2java;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField cityTextField;

    @FXML
    private Button getWeatherButton;

    @FXML
    private TextArea resultTextArea;

    private WeatherService weatherService = new WeatherService();

    @FXML
    private void handleGetWeather() {
        String city = cityTextField.getText();
        if (city == null || city.isEmpty()) {
            resultTextArea.setText("Please enter a city name.");
            return;
        }

        try {
            Weather weather = weatherService.getWeather(city);
            if (weather.getMain() != null) {
                double temp = weather.getMain().getTemp();
                int pressure = weather.getMain().getPressure();
                int humidity = weather.getMain().getHumidity();

                resultTextArea.setText("Temperature: " + temp + "K\n" +
                        "Pressure: " + pressure + "hPa\n" +
                        "Humidity: " + humidity + "%");
            } else {
                resultTextArea.setText("Error: Weather data is not available.");
            }
        } catch (Exception e) {
            resultTextArea.setText("Error fetching weather data: " + e.getMessage());
        }
    }
}
