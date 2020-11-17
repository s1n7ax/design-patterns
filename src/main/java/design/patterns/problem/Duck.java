package design.patterns.problem;

public abstract class Duck {

	public abstract void display();

	public void quack() {
		System.out.println("quack");
	}

	public void swim() {
		System.out.println("swimming");
	}
}
