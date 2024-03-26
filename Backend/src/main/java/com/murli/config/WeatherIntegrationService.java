package com.murli.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class WeatherIntegrationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${rapidapi.key}")
    private String rapidApiKey;

    @Value("${openweathermap.key}")
    private String openWeatherMapApiKey;


    public String getForecastSummary(String city) throws IOException, InterruptedException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", rapidApiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "https://forecast9.p.rapidapi.com/rapidapi/forecast/"+city+"/summary/",
                HttpMethod.GET,
                entity,
                String.class
        );

        System.out.println(response);

        return response.getBody();
    }

    public String getHourlyForecast(String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("appid", openWeatherMapApiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "https://api.openweathermap.org/data/2.5/forecast?q=" + city,
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }
}
