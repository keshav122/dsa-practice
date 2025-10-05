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

class Train implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending By Train Logic");
    }
}

class LogisticsFactory {

    public static Logistics getLogistics(String mode) {
        if (mode == "Road") {
            return new Road();
        } else if (mode == "Train") {
            return new Train();
        }
        return new Air();
    }
}

class LogisticsService {
    public void send(String mode) {
        // no more dealing with the object creation logic
        Logistics logistics = LogisticsFactory.getLogistics(mode);
        logistics.send();
    }
}

public class FactoryClass {

}
