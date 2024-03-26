package com.murli.service;

import com.murli.config.WeatherIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class WeatherService {

    @Autowired
    private WeatherIntegrationService weatherIntegrationService;

    public String getForecastSummary(String city) throws IOException, InterruptedException {
        return weatherIntegrationService.getForecastSummary(city);
    }

    public String getHourlyForecast(String city) {
        return weatherIntegrationService.getHourlyForecast(city);
    }
}