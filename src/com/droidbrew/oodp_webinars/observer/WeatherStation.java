package com.droidbrew.oodp_webinars.observer;

public class WeatherStation {
	public WeatherStation(){
		WeatherData weatherData = new WeatherData();

		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		(new Thread(statisticsDisplay)).start();
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		(new Thread(forecastDisplay)).start();
		// more displays - more threads?

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
