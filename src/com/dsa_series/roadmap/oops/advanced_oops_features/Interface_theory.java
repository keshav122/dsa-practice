package com.dsa_series.roadmap.oops.advanced_oops_features;

//Abstraction
interface CarInterface {
    public void start();

    public void numberOfGears();

    // default and static - Post Java 8
    default void airbags() {
        System.out.println("Car has 5 airbags");
    }

    static void vehicleType() {
        System.out.println("It is a Car");
    }

}

class ManualCar implements CarInterface, SunRoof {

    @Override
    public void start() {
        System.out.println("Manual Car is starting");
    }

    @Override
    public void numberOfGears() {
        System.out.println("Manual Car has 6 gears");
    }

    public void airbags() {
        System.out.println("Car has 6 airbags");
    }

    @Override
    public void sunroof() {
        System.out.println("It has a normal sunroof");
    }
}

interface SunRoof {
    public void sunroof();
}

public class Interface_theory {

    public static void main(String[] args) {
        ManualCar c = new ManualCar();
        c.start();
        c.numberOfGears();
        c.airbags();// This will print the child class method -> Car has 6 airbags
        CarInterface.vehicleType(); // Cannot access using c.vehicleType()
        c.sunroof();
    }
}
