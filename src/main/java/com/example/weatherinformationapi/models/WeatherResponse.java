package com.example.weatherinformationapi.models;

import lombok.Data;

@Data
public class WeatherResponse {
    private String city;
    private String description;
    private double temperature;
    private double humidity;
}
