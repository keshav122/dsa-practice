package com.dsa_series.roadmap.beginnerproblems.basic_maths;

public class GCDOfTwoNumber {
    public int GCD(int n1, int n2) {
        if (n1 % n2 == 0) {
            return n2;
        }
        return GCD(n2, n1 % n2);
    }

    public int GCD_BF(int n1, int n2) {
        int gcd = 1;
        int minValue = Math.min(n1, n2);
        for (int i = 1; i <= minValue; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = Math.max(i, gcd);
            }
        }
        return gcd;
    }

    public int GCD_Better(int n1, int n2) {
        int gcd = 1;
        for (int i = Math.min(n1, n2); i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                return i;
            }
        }
        return gcd;
    }

    public int GCD_optimal(int n1, int n2) {
        while (n1 > 0 && n2 > 0) {
            if (n1 > n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }
        return (n1 == 0) ? n2 : n1;
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 4;
        GCDOfTwoNumber g = new GCDOfTwoNumber();
        System.out.println(g.GCD(a, b));
        System.out.println(g.GCD_1(a, b));
    }
}
