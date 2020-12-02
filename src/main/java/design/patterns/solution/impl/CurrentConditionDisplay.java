package design.patterns.solution.impl;

import design.patterns.solution.Display;
import design.patterns.solution.Observer;

/**
 * CurrentConditionDisplay
 */
public class CurrentConditionDisplay implements Observer, Display {
	private long temperature;
	private long humidity;
	private long pressure;

	@Override
	public void display() {
		System.out
				.println(String.format("Temperature::%s\nHumidity::%s\nPressure::%s", temperature, humidity, pressure));
	}

	@Override
	public void update(long temperature, long humidity, long pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;

		display();
	}
}
