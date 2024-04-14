package com.lld.lecture.streams_and_lambdas.functional_interface;

public class Main {

	public static void main(String[] args) {
		
		//Way 1 -> Create a class that implements Interface
		DemoClass obj1 = new DemoClass();
		obj1.run();
		obj1.fly();
		//obj1.walk();
		DemoInterface.eat();//we can call the static method without the object for a class or a interface
		
		
		//Way 2 -> Anonymous Class
		DemoInterface obj2 = new DemoInterface() {
			
			@Override
			public void run() {
				System.out.println("Anonymous way of creating object of interface");
				
			}
			
			@Override
			public void fly() {
				System.out.println("Fly method in the anonymous class");
			}
		};
		
		obj2.run();
		obj2.fly();
		
	}
}
