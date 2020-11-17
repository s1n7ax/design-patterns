package design.patterns.solution;

public abstract class Duck {

	private QuackBehaviour quackBehaviour;
	private FlyBehaviour flyBehaviour;

	public abstract void display();

	public void performQuack() {
		quackBehaviour.quack();
	}

	public void performFly() {
		flyBehaviour.fly();
	}

	public void swim() {
		System.out.println("swimming");
	}
}
