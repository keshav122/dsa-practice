package com.dsa_series.roadmap.oops.advance_programming_in_oops;

class Calculator<T extends Number> {

    public double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
}

public class BoundedTypeParameters {

    public static void main(String[] args) {
        // The type is bounded over here as we can only select a
        // type which is extending the class Number
        Calculator<Integer> obj = new Calculator<>();

    }
}
