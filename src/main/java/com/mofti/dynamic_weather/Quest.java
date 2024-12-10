package com.mofti.dynamic_weather;

/**
 * Represents a quest that is available based on specific weather conditions.
 * This class listens for weather changes and checks if the quest can be activated
 * based on the current weather condition.
 */
public class Quest implements WeatherManager.WeatherChangeListener {
    
    private String npc; // NPC offering the quest
    private WeatherManager.WeatherCondition requiredWeather; // Weather condition required to trigger the quest
    private String description; // A brief description of the quest

    /**
     * Constructor to initialise a quest.
     * 
     * @param npc The NPC offering the quest.
     * @param requiredWeather The weather condition required to trigger the quest.
     * @param description A description of what the quest entails.
     */
    public Quest(String npc, WeatherManager.WeatherCondition requiredWeather, String description) {
        this.npc = npc;
        this.requiredWeather = requiredWeather;
        this.description = description;
    }

    /**
     * Called when the weather changes.
     * It checks if the current weather matches the required weather for the quest.
     * If the weather matches, the quest becomes available.
     * 
     * @param newWeather The new weather condition after the change.
     */
    @Override
    public void onWeatherChange(WeatherManager.WeatherCondition newWeather) {
        if (newWeather == requiredWeather) {
            System.out.println("Quest available: " + description);
        } else {
            System.out.println("Quest unavailable due to weather.");
        }
    }

    // Getter methods to access quest details

    /**
     * Gets the NPC offering the quest.
     * 
     * @return The NPC's name.
     */
    public String getNpc() {
        return npc;
    }

    /**
     * Gets the required weather condition for the quest.
     * 
     * @return The required weather condition.
     */
    public WeatherManager.WeatherCondition getRequiredWeather() {
        return requiredWeather;
    }

    /**
     * Gets the description of the quest.
     * 
     * @return The quest description.
     */
    public String getDescription() {
        return description;
    }
}
