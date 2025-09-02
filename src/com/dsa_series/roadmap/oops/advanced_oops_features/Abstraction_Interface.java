/*Author: keshav122 */
package com.dsa_series.roadmap.oops.advanced_oops_features;

//Abstraction
abstract class Car {
    abstract public void start();

    public void noise() {
        System.out.println("Noise ...");
    }
}

// Befor Java 8 , we could not have implemented methods inside an Interface
interface CarInterface {
    abstract public void start();

    // default and static
    default void noise() {
        System.out.println("Noise ...");
    }

    static void numberOfWheels() {
        System.out.println("Wheels : 4");
    }
}

class ManualCar implements CarInterface {

    @Override
    public void start() {
        System.out.println("Manual Car is starting");
    }

    public void printName() {
        System.out.println("hey ! I am a manual car");
    }

}

class AutomaticCar extends Car {

    @Override
    public void start() {
        System.out.println("Automatic Car is starting");
    }

}

public class Abstraction_Interface {

    public static void main(String[] args) {
        // ManualCar mc = new ManualCar();
        // We can always do this
        ManualCar mc = new ManualCar();
        mc.start();
        mc.noise();

        // mc.printName();// Cannot do this if mc is Object of Car , however if mc is
        // object of
        // Manual Car then we can do this

        // usually we do Car mc = new ManualCar(); --> Industry Standard
        // because Manual Car can implement its own methods which the Car will have no
        // information of

        Car ac = new AutomaticCar();
        ac.start();
        ac.noise();

    }
}
