package design.patterns.solution.impl;

import design.patterns.solution.Subject;

import java.util.ArrayList;
import java.util.List;

import design.patterns.solution.Observer;

/**
 * WeatherManager
 */
public class WeatherManager implements Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	private long temperature;
	private long humidity;
	private long pressure;

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		observers.forEach(observer -> {
			observer.update(temperature, humidity, pressure);
		});
	}

	public void measurementChanged() {
		notifyObservers();
	}

	/**
	 * setMeasurement simulate getting data from devices
	 * 
	 * @param temperature
	 * @param humidity
	 * @param pressure
	 */
	public void setMeasurement(long temperature, long humidity, long pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;

		measurementChanged();
	}
}
