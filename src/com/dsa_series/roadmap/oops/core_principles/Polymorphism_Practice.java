package com.dsa_series.roadmap.oops.core_principles;

class ShapeCalculator {

    public void area(int radius) {
        int area = (int) ((3.14) * radius * radius);
        System.out.println("Area of Circle : " + area);
    }

    public void area(int length, int width) {
        int area = length * width;
        System.out.println("Area of Rectangle : " + area);
    }

    public void area(int base1, int base2, int height) {
        int area = ((base1 + base2) * height) / 2;
        System.out.println("Area of Trapezoid : " + area);
    }
}

public class Polymorphism_Practice {

}
