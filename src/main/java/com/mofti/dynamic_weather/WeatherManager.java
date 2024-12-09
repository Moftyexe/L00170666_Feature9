package com.mofti.dynamic_weather;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages weather conditions and notifies listeners about weather changes.
 * This class handles the current weather state, changes in weather, and the
 * gameplay effects of each weather condition.
 */
public class WeatherManager {
    private WeatherCondition currentWeather;
    private final List<WeatherChangeListener> listeners = new ArrayList<>();

    /**
     * Enum representing the different types of weather conditions.
     */
    public enum WeatherCondition {
        SUNNY, RAIN, SNOW, STORM
    }

    /**
     * Constructor that initializes the WeatherManager with a default weather condition (SUNNY).
     */
    public WeatherManager() {
        // Initialize with default weather
        this.currentWeather = WeatherCondition.SUNNY;
    }

    /**
     * Randomly changes the weather to one of the available weather conditions.
     * This method updates the current weather and notifies all registered listeners
     * about the weather change.
     */
    public void changeWeather() {
        // Get all weather conditions and choose one at random
        WeatherCondition[] weatherConditions = WeatherCondition.values();
        currentWeather = weatherConditions[(int) (Math.random() * weatherConditions.length)];
        
        // Notify listeners about the weather change
        notifyWeatherChange();
    }

    /**
     * Gets the current weather condition.
     *
     * @return The current weather condition.
     */
    public WeatherCondition getCurrentWeather() {
        return currentWeather;
    }

    /**
     * Gets the gameplay effect associated with the current weather condition.
     *
     * @return A description of the gameplay effects for the current weather condition.
     */
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

    /**
     * Adds a listener that will be notified when the weather changes.
     *
     * @param listener The listener to add. Must implement the WeatherChangeListener interface.
     */
    public void addWeatherChangeListener(WeatherChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * Notifies all registered listeners about a weather change.
     */
    private void notifyWeatherChange() {
        for (WeatherChangeListener listener : listeners) {
            listener.onWeatherChange(currentWeather);
        }
    }

    /**
     * Interface for objects that want to listen to weather changes.
     * Implementing classes must define the onWeatherChange method to handle weather updates.
     */
    public interface WeatherChangeListener {
        /**
         * Called when the weather changes.
         *
         * @param newWeather The new weather condition.
         */
        void onWeatherChange(WeatherCondition newWeather);
    }
}
