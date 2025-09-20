package com.dsa_series.roadmap.oops.oops_design_and_lifecycle_mgt;

//Base class for all birds
class Bird {
    public void eat() {
        System.out.println("I am eating");
    }
}

// Interface for flying birds
interface Flyable {
    void fly();
}

// Sparrow is a flying bird
class Sparrow extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("I am flying");
    }
}

// Penguin is a non-flying bird
class Penguin extends Bird {

}

public class LiskovSubstitutionPrinciple_Correct {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        ((Flyable) sparrow).fly();// Works fine

        Bird penguin = new Penguin();
        // Penguin does not implement Flyable so no fly call is expected
        penguin.eat();

    }
}
