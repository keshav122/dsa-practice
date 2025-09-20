package com.dsa_series.roadmap.oops.oops_design_and_lifecycle_mgt;

abstract class Shape {
    abstract void draw();
}

class Rectangle extends Shape {

    @Override
    void draw() {
        System.out.println("Draw a rectangle");
    }
}

class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Draw a circle");
    }
}

public class OpenClosedPrinciple {

    // The Open closed principle states that the classes should be written in such a
    // way so that we don't need to modify the originally written class
    // So in the above example we should not modify the Shape class unless
    // absolutely necessary.
}
