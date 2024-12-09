package com.mofti.dynamic_weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherManager {
    private WeatherCondition currentWeather;
    private final List<WeatherChangeListener> listeners = new ArrayList<>();

    // Enum for weather conditions
    public enum WeatherCondition {
        SUNNY, RAIN, SNOW, STORM
    }

    public WeatherManager() {
        // Initialise with default weather
        this.currentWeather = WeatherCondition.SUNNY;
    }

    public void changeWeather() {
        WeatherCondition[] weatherConditions = WeatherCondition.values();
        currentWeather = weatherConditions[(int) (Math.random() * weatherConditions.length)];
        notifyWeatherChange();
    }

    public WeatherCondition getCurrentWeather() {
        return currentWeather;
    }

    public String getGameplayEffect() {
        switch (currentWeather) {
            case RAIN:
                return "Slippery terrain, reduced speed.";
            case SNOW:
                return "Reduced visibility, cold damage.";
            case STORM:
                return "Increased difficulty in climbing.";
            case SUNNY:
            default:
                return "Clear weather, no hindrance.";
        }
    }

    // Add listener
    public void addWeatherChangeListener(WeatherChangeListener listener) {
        listeners.add(listener);
    }

    // Notify all listeners about the weather change
    private void notifyWeatherChange() {
        for (WeatherChangeListener listener : listeners) {
            listener.onWeatherChange(currentWeather);
        }
    }

    // Interface for weather change listeners
    public interface WeatherChangeListener {
        void onWeatherChange(WeatherCondition newWeather);
    }
}
