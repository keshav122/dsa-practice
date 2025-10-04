package com.low_level_design.design_patterns.creational_patterns.factory;

interface Logistics {
    void send();
}

class Road implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending By Road Logic");
    }

}

class Air implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending By Air Logic");
    }
}

class LogisticsService {
    // The problem here is that still the logistics service is
    // taking care of the object creation of the logistics class while
    // it should only be dealing with the send operation

    // Logistics Service is violating SRP as it does two things
    // it identifies what kind of Logistics class is required
    // and then also implements the send function
    public void send(String mode) {
        if (mode == "Air") {
            Logistics logistics = new Air();
            logistics.send();
        } else if (mode == "Road") {
            Logistics logistics = new Road();
            logistics.send();
        }
    }
}

public class FactoryDesignPattern_Issue {

}
