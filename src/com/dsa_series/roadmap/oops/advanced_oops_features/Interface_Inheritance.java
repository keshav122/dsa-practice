package com.dsa_series.roadmap.oops.advanced_oops_features;

interface Vehicle {
    public void start();

    default void honk() {
        System.out.println("Vehicle is honking");
    }
}

interface Car extends Vehicle {
    public void drive();

    default void honk() {
        System.out.println("Car is honking");
    }
}

class ManualCar implements Car {

    @Override
    public void start() {
        System.out.println("Starting :");
    }

    @Override
    public void drive() {
        System.out.println("Driving :");
    }

}

public class Interface_Inheritance {

    public static void main(String[] args) {
        ManualCar m = new ManualCar();
        m.honk();// Will print Car is honking
        // If we want to override that we can create honk method in the ManualCar class
    }
}
