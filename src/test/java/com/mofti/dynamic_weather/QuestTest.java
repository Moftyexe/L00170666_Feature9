package com.mofti.dynamic_weather;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Quest functionality.
 * Ensures that quests are initialised correctly and respond appropriately to weather changes.
 */
class QuestTest {

    private Quest quest;
    private WeatherManager.WeatherCondition sunnyCondition;

    /**
     * Sets up test data before each test method.
     * Initialises a Quest instance with predefined values.
     */
    @BeforeEach
    void setUp() {
        sunnyCondition = WeatherManager.WeatherCondition.SUNNY;
        quest = new Quest("Old Farmer", sunnyCondition, "Help plant crops during sunny weather.");
    }

    /**
     * Tests the Quest constructor and validates its initialisation.
     * Ensures all fields are set correctly.
     */
    @Test
    void testQuest() {
        assertNotNull(quest, "Quest object should not be null.");
        assertEquals("Old Farmer", quest.getNpc(), "NPC name should match the expected value.");
        assertEquals(sunnyCondition, quest.getRequiredWeather(), "Required weather should match the given condition.");
        assertEquals("Help plant crops during sunny weather.", quest.getDescription(), "Quest description should match the expected value.");
    }

    /**
     * Tests the onWeatherChange method.
     * Ensures that the quest responds correctly when weather conditions change.
     */
    @Test
    void testOnWeatherChange() {
        // Simulate sunny weather
        quest.onWeatherChange(WeatherManager.WeatherCondition.SUNNY);
        // TODO: Verify console output or state changes if applicable.

        // Simulate non-sunny weather
        quest.onWeatherChange(WeatherManager.WeatherCondition.RAIN);
        // TODO: Verify behaviour for non-matching weather.
    }

    /**
     * Tests the getNpc method.
     * Ensures that the correct NPC name is returned.
     */
    @Test
    void testGetNpc() {
        assertEquals("Old Farmer", quest.getNpc(), "NPC name should match the expected value.");
    }

    /**
     * Tests the getRequiredWeather method.
     * Ensures that the correct required weather condition is returned.
     */
    @Test
    void testGetRequiredWeather() {
        assertEquals(sunnyCondition, quest.getRequiredWeather(), "Required weather should match the expected value.");
    }

    /**
     * Tests the getDescription method.
     * Ensures that the correct quest description is returned.
     */
    @Test
    void testGetDescription() {
        assertEquals("Help plant crops during sunny weather.", quest.getDescription(), "Quest description should match the expected value.");
    }
}
