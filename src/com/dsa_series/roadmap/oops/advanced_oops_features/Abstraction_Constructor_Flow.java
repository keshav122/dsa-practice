package com.dsa_series.roadmap.oops.advanced_oops_features;

//Abstraction
abstract class Car {
    // We can create a constructor inside a abstract class
    Car() {
        System.out.println("Car constructor is called");
    }

    abstract public void start();

    public void noise() {
        System.out.println("Noise ...");
    }
}

abstract class Dealer extends Car {
    int numberOfCars;

    Dealer() {
        System.out.println("Dealer constructor is called");
    }

    Dealer(int numberOfCars) {
        System.out.println("Dealer parameterised constructor is called");
        this.numberOfCars = numberOfCars;
    }
}

class ManualCar extends Dealer {
    ManualCar() {
        System.out.println("Manual Car Constructor");
    }
    // ManualCar(int numberOfCars) {
    // super(numberOfCars);
    // System.out.println("Manual Car Constructor");
    // }

    @Override
    public void start() {
        System.out.println("Manual Car is starting");
    }

    public void printName() {
        System.out.println("hey ! I am a manual car");
    }

}

public class Abstraction_Constructor_Flow {

    public static void main(String[] args) {
        ManualCar mc = new ManualCar();
        mc.start();
    }
}
