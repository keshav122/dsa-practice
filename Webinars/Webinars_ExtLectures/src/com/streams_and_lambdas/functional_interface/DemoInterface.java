package com.streams_and_lambdas.functional_interface;

public interface DemoInterface {

	void run(); // abstract method -> Method without body
	
	void fly();
	
	//default just means that we can define the method with body
	default void walk() {
		System.out.println("Walking");
	}
	
	static void eat() {
		System.out.println("Eating");
	}
}
