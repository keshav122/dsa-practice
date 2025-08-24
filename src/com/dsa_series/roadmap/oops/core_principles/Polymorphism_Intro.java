package com.dsa_series.roadmap.oops.core_principles;

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

}

public class Polymorphism_Intro {

    public static void main(String[] args) {
        Calculator obj = new Calculator();
        // Compile - time polymorphism - because it is from the class blueprint
        // so the compiler can easily figure out which method to use
        obj.add(1, 2);
    }
}
