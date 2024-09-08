package com.roadmap.recursion.implementation_problems;

public class Pow_x_n {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            return x * myPow(x, n - 1);
        } else {
            n *= -1;
            return 1 / (x * myPow(x, n - 1));
        }

    }
}
