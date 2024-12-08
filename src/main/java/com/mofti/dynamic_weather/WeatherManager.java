package com.mofti.dynamic_weather;

public class WeatherManager {
    private String currentWeather;

    public void changeWeather() {
        String[] weatherConditions = {"Sunny", "Rain", "Snow", "Storm"};
        currentWeather = weatherConditions[(int) (Math.random() * weatherConditions.length)];
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public String getGameplayEffect() {
        switch (currentWeather) {
            case "Rain": return "Slippery terrain, reduced speed.";
            case "Snow": return "Reduced visibility, cold damage.";
            case "Storm": return "Increased difficulty in climbing.";
            default: return "Clear weather, no hindrance.";
        }
    }
}