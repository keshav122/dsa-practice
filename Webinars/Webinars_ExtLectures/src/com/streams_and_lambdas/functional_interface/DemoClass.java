package com.streams_and_lambdas.functional_interface;

public class DemoClass implements DemoInterface {

	@Override
	public void run() {
		System.out.println("Implementing Run Method");

	}

	@Override
	public void fly() {
		System.out.println("Implementing Fly Method");
	}

}
