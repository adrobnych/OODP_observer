package com.droidbrew.oodp_webinars.observer;

import com.droidbrew.oodp_webinars.koan.COUT;

class ForecastDisplay implements Display, Runnable {
	private float currentPressure = 29.92f;  
	private float lastPressure;
	WeatherData weatherData;


	public ForecastDisplay(WeatherData weatherData) {
		super();
		this.weatherData = weatherData;
	}

	public void update() {
			lastPressure = currentPressure;
			currentPressure = weatherData.getPressure();
			display();
	}

	public void display() {
		COUT.println("Forecast: ");
		if (currentPressure > lastPressure) {
			COUT.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			COUT.println("More of the same");
		} else if (currentPressure < lastPressure) {
			COUT.println("Watch out for cooler, rainy weather");
		}
	}

	@Override
	public void run() {
		while(true)
			if(weatherData.isMeasurementsChanged()){
				update();
				weatherData.setMeasurementsChanged(false);    // but how about other displays?
			}	                                              // display dictate weatherData how to work?
	}
}