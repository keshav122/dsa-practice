package com.dsa_series.roadmap.recursion.implementation_problems;

public class Pow_x_n {

    public double myPow_IterativeSol(double x, int n) {
        if (n == 0)
            return 1;
        long num = n;
        double ans = 1;
        if (num < 0) {
            x = 1 / x;
            num = -num;
        }
        while (num > 0) {
            if (num % 2 == 1) {
                ans = ans * x;
                num = num - 1;
            } else {
                x = x * x;
                num = num / 2;
            }
        }
        return ans;
    }

    public double myPow_Rec(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            return x * myPow_Rec(x, n - 1);
        } else {
            n *= -1;
            return 1 / (x * myPow_Rec(x, n - 1));
        }

    }

    // Based on the iterative solution
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long num = n;
        if (n < 0) {
            x = 1 / x;
            num = -n;
        }
        if (num % 2 == 1) {
            return x * myPow(x, (int) (num - 1));
        } else {
            return myPow(x * x, (int) (num / 2));
        }

    }
}
