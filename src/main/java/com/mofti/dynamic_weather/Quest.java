package com.mofti.dynamic_weather;

public class Quest implements WeatherManager.WeatherChangeListener {
    private String npc;
    private WeatherManager.WeatherCondition requiredWeather;
    private String description;

    public Quest(String npc, WeatherManager.WeatherCondition requiredWeather, String description) {
        this.npc = npc;
        this.requiredWeather = requiredWeather;
        this.description = description;
    }

    @Override
    public void onWeatherChange(WeatherManager.WeatherCondition newWeather) {
        if (newWeather == requiredWeather) {
            System.out.println("Quest available: " + description);
        } else {
            System.out.println("Quest unavailable due to weather.");
        }
    }
}

