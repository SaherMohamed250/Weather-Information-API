package com.example.weatherinformationapi.controllers;

import com.example.weatherinformationapi.models.WeatherResponse;
import com.example.weatherinformationapi.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/ar/{city}")
    public ResponseEntity<?> getWeatherAr(@PathVariable String city){
        WeatherResponse response = weatherService.getWeatherByCityAr(city);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
    @GetMapping("/en/{city}")
    public ResponseEntity<?> getWeatherEn(@PathVariable String city){
        WeatherResponse response = weatherService.getWeatherByCityEn(city);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
}
