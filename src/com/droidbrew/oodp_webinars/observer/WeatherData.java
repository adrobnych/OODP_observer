package com.droidbrew.oodp_webinars.observer;

public class WeatherData {
	private float temperature;
	private float humidity;
	private float pressure;
	boolean measurementsChanged;

	public WeatherData() { }

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged = true;
	}

	public synchronized float getTemperature() {
		return temperature;
	}

	public synchronized float getHumidity() {
		return humidity;
	}

	public synchronized float getPressure() {
		return pressure;
	}

	public synchronized void setMeasurementsChanged(boolean measurementsChanged) {
		this.measurementsChanged = measurementsChanged;
	}

	public synchronized boolean isMeasurementsChanged() {
		return measurementsChanged;
	}
}
