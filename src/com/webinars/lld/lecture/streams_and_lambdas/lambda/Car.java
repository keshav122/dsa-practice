package com.webinars.lld.lecture.streams_and_lambdas.lambda;

/*# Author: keshav122*/
public class Car {

	String name;
	int power;
	int price;

	Car(String name, int power, int price) {
		this.name = name;
		this.power = power;
		this.price = price;
	}

	@Override
	public String toString() {
		return "[name= " + this.name + ", Price= " + this.price + ", Power= " + this.power + "]\n";
	}
}
