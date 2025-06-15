package com.example.weatherinformationapi.services;

import com.example.weatherinformationapi.configurations.WeatherConfig;
import com.example.weatherinformationapi.models.WeatherResponse;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Autowired
    private WeatherConfig weatherConfig;
    private RestTemplate restTemplate=new RestTemplate();

    public WeatherResponse getWeatherByCity(String city, String lang) {
        String url = String.format("%s?q=%s&appid=%s&units=metric&lang=%s",
                weatherConfig.getUrl(), city, weatherConfig.getKey(), lang);

        JsonNode root = restTemplate.getForObject(url, JsonNode.class);

        if (root == null || !root.has("main") || !root.has("weather")) {
            throw new RuntimeException("Cannot get weather for city: " + city);
        }

        WeatherResponse response = new WeatherResponse();
        response.setCity(root.get("name").asText());
        response.setTemperature(root.get("main").get("temp").asDouble());
        response.setHumidity(root.get("main").get("humidity").asDouble());
        response.setDescription(root.get("weather").get(0).get("description").asText());

        return response;
    }

    public WeatherResponse getWeatherByCityAr(String city) {
        return getWeatherByCity(city, "ar");
    }

    public WeatherResponse getWeatherByCityEn(String city) {
        return getWeatherByCity(city, "en");
    }

}
