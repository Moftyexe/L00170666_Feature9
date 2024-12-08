package com.mofti.dynamic_weather;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 */
public class WeatherManagerTest {
    @Test
    public void testChangeWeather() {
        WeatherManager weatherManager = new WeatherManager();
        weatherManager.changeWeather();
        assertNotNull(weatherManager.getCurrentWeather());
    }

    @Test
    public void testGetGameplayEffect() {
        WeatherManager weatherManager = new WeatherManager();
        weatherManager.changeWeather();
        assertNotNull(weatherManager.getGameplayEffect());
    }
}