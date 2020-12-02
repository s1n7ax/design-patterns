package design.patterns.solution;

/**
* Subject
*/
public interface Subject {

	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers();
}
