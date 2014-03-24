package com.droidbrew.oodp_webinars.observer;

import com.droidbrew.oodp_webinars.koan.COUT;

class StatisticsDisplay implements Display, Runnable {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;
	WeatherData weatherData;


	public StatisticsDisplay(WeatherData weatherData) {
		super();
		this.weatherData = weatherData;
	}

	public void update() {
			float temp = weatherData.getTemperature();
			tempSum += temp;
			numReadings++;

			if (temp > maxTemp) {
				maxTemp = temp;
			}
 
			if (temp < minTemp) {
				minTemp = temp;
			}

			display();
	}

	public void display() {
		COUT.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}

	@Override
	public void run() {
		while(true)
			if(weatherData.isMeasurementsChanged()){
				update();
				weatherData.setMeasurementsChanged(false);
			}
	}
}