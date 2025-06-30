/*Author: keshav122 */
package com.roadmap.beginnerproblems.basic_maths;

public class GCDOfTwoNumber {
    public int GCD(int n1, int n2) {
        if (n1 % n2 == 0) {
            return n2;
        }
        return GCD(n2, n1 % n2);
    }

    public int GCD_1(int n1, int n2) {
        int gcd = 1;
        int minValue = Math.min(n1, n2);
        for (int i = 1; i <= minValue; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = Math.max(i, gcd);
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 4;
        GCDOfTwoNumber g = new GCDOfTwoNumber();
        System.out.println(g.GCD(a, b));
        System.out.println(g.GCD_1(a, b));
    }
}
