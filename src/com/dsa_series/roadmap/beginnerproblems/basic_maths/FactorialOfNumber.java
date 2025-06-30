package com.dsa_series.roadmap.beginnerproblems.basic_maths;

public class FactorialOfNumber {
    public int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
