package design.patterns.solution.impl;

import design.patterns.solution.Duck;
import design.patterns.solution.QuackBehaviour;
import design.patterns.solution.FlyBehaviour;

public class RedheadDuck extends Duck {

	private QuackBehaviour quackBehaviour;
	private FlyBehaviour flyBehaviour;

	public RedheadDuck() {
		this.quackBehaviour = new Quack();
		this.flyBehaviour = new FlyWithWings();
	}

	public void display() {
		System.out.println("I have a red head");
	}

	public void performQuack() {
		quackBehaviour.quack();
	}

	public void performFly() {
		flyBehaviour.fly();
	}

}
