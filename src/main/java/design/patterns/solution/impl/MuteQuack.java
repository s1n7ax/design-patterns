package design.patterns.solution.impl;

import design.patterns.solution.QuackBehaviour;

public class MuteQuack implements QuackBehaviour {

	public void quack() {
		System.out.println("<<silent>>");
	}

}
