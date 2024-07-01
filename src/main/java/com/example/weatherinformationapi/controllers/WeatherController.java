package com.example.weatherinformationapi.controllers;

import com.example.weatherinformationapi.models.WeatherResponse;
import com.example.weatherinformationapi.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherResponse getWeather(@RequestParam String city){
        return weatherService.getWeatherByCity(city);
    }
}
