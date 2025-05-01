package com.roadmap.beginnerproblems.basic_maths;

public class LCMOfTwoNos {
    public int LCM(int n1, int n2) {
        return (n1 * n2) / GCD(n1, n2);
    }

    public int GCD(int n1, int n2) {
        if (n1 % n2 == 0) {
            return n2;
        }
        return GCD(n2, n1 % n2);
    }
}
