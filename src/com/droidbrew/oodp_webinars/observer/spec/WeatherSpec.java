package com.droidbrew.oodp_webinars.observer.spec;

import static org.junit.Assert.*;

import org.junit.Test;

import com.droidbrew.oodp_webinars.koan.COUT;
import com.droidbrew.oodp_webinars.koan.Koan;
import com.droidbrew.oodp_webinars.observer.WeatherStation;

public class WeatherSpec extends Koan{

	@Test
	public void test() throws InterruptedException {
		WeatherStation ws = new WeatherStation();
		Thread.sleep(500);
		assertEquals(___, COUT.getLastLines(3));
	}

}
