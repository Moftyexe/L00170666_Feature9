package com.mofti.dynamic_weather;

public class App {
    public static void main(String[] args) {
        WeatherManager weatherManager = new WeatherManager();

        // Create quests
        Quest quest1 = new Quest("Old Farmer", WeatherManager.WeatherCondition.RAIN, "Help plant crops during rain.");
        Quest quest2 = new Quest("Mountain Hermit", WeatherManager.WeatherCondition.SUNNY, "Collect rare herbs in sunny weather.");

        // Add quests as listeners to weather changes
        weatherManager.addWeatherChangeListener(quest1);
        weatherManager.addWeatherChangeListener(quest2);

        // Simulate weather changes
        for (int i = 0; i < 5; i++) {
            weatherManager.changeWeather();
            System.out.println("Current Weather: " + weatherManager.getCurrentWeather());
            System.out.println("Effect: " + weatherManager.getGameplayEffect());
        }
    }
}
