package com.esprit.microservice.menu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.json.JSONObject;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String weatherApiKey;

    @Value("${spoonacular.api.key}")
    private String spoonacularApiKey;

    private static final String WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String SPOONACULAR_API_URL = "https://api.spoonacular.com/recipes/complexSearch";

    public String getWeather(String cityName) {
        String url = UriComponentsBuilder.fromHttpUrl(WEATHER_API_URL)
                .queryParam("q", cityName)
                .queryParam("appid", weatherApiKey)
                .queryParam("units", "metric")
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    public String getFoodRecommendations(String weatherJson) {
        JSONObject json = new JSONObject(weatherJson);
        String mainWeather = json.getJSONArray("weather")
                .getJSONObject(0)
                .getString("main")
                .toLowerCase();

        String query;
        if (mainWeather.contains("rain") || mainWeather.contains("snow") || mainWeather.contains("cloud")) {
            query = "soup";
        } else if (mainWeather.contains("clear")) {
            query = "smoothie";
        } else {
            query = "salad";
        }

        String url = UriComponentsBuilder.fromHttpUrl(SPOONACULAR_API_URL)
                .queryParam("query", query)
                .queryParam("diet", "vegetarian")
                .queryParam("apiKey", spoonacularApiKey)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
