package com.dsa_series.roadmap.oops.oops_design_and_lifecycle_mgt;

class Bird {
    public void fly() {
        System.out.println("I am flying");
    }
}

class Sparrow extends Bird {
    // Sparrow can fly
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}

public class LiskovSubsitutionPrinciple_Incorrect {

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        sparrow.fly();// Works fine

        Bird penguin = new Penguin();
        // The following functionality is affecting the correctness of the program
        penguin.fly();// throws exception

    }
}
