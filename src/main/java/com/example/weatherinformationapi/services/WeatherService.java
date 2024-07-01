package com.example.weatherinformationapi.services;

import com.example.weatherinformationapi.models.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse getWeatherByCity(String city){
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

            Map<String, Object> response = restTemplate.getForObject(url, Map.class);

            WeatherResponse weatherResponse = new WeatherResponse();
            weatherResponse.setCity((String) response.get("name"));
            weatherResponse.setDescription((String) ((Map) ((List) response.get("weather")).get(0)).get("description"));

            Object temp = ((Map) response.get("main")).get("temp");
            if (temp instanceof Integer) {
                weatherResponse.setTemperature(((Integer) temp).doubleValue());
            } else if (temp instanceof Double) {
                weatherResponse.setTemperature((Double) temp);
            }

            Object humidity = ((Map) response.get("main")).get("humidity");
            if (humidity instanceof Integer) {
                weatherResponse.setHumidity(((Integer) humidity).doubleValue());
            } else if (humidity instanceof Double) {
                weatherResponse.setHumidity((Double) humidity);
            }

            return weatherResponse;
        }
}