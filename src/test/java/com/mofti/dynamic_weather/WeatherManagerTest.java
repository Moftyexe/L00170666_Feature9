package com.mofti.dynamic_weather;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for WeatherManager functionality.
 * Ensures that weather changes are handled correctly and that gameplay effects are returned as expected.
 */
class WeatherManagerTest {

    private WeatherManager weatherManager;

    /**
     * Sets up test data before each test method.
     * Initialises a WeatherManager instance with default values.
     */
    @BeforeEach
    void setUp() {
        weatherManager = new WeatherManager();
    }

    /**
     * Tests the changeWeather method.
     * Ensures that the weather changes to a new condition and is not null.
     */
    @Test
    void testChangeWeather() {
        WeatherManager.WeatherCondition initialWeather = weatherManager.getCurrentWeather();
        weatherManager.changeWeather();
        WeatherManager.WeatherCondition newWeather = weatherManager.getCurrentWeather();

        assertNotNull(newWeather, "New weather condition should not be null.");
        assertNotEquals(initialWeather, newWeather, "Weather condition should change.");
    }

    /**
     * Tests the getGameplayEffect method.
     * Ensures that the correct gameplay effect is returned for the current weather condition.
     */
    @Test
    void testGetGameplayEffect() {
        weatherManager.changeWeather();
        String effect = weatherManager.getGameplayEffect();

        assertNotNull(effect, "Gameplay effect should not be null.");
        assertTrue(effect.length() > 0, "Gameplay effect should not be empty.");
    }
}
