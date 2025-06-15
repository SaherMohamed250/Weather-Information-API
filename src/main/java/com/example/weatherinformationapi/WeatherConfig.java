package com.example.weatherinformationapi.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "openweather.api")
public class WeatherConfig {
    private String key;
    private String url;
}
