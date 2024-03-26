package com.murli.controller;

import com.murli.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/forecast-summary")
    public ResponseEntity<String> getForecastSummary(@RequestParam String city) throws IOException, InterruptedException {
        System.out.println(city);
        return ResponseEntity.ok(weatherService.getForecastSummary(city));
    }

    @GetMapping("/weather/hourly-forecast")
    public ResponseEntity<String> getHourlyForecast(@RequestParam String city) {
        return ResponseEntity.ok(weatherService.getHourlyForecast(city));
    }
}