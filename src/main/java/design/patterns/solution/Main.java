package design.patterns.solution;

import design.patterns.solution.impl.*;

public class Main {

	public static void main(String[] args) {
		RedheadDuck duck = new RedheadDuck();
		duck.display();
		duck.swim();
		duck.performQuack();
		duck.performFly();
	}

}
