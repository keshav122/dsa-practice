package com.contests.codeforces.round_1047_Div3;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while (T-- > 0) {
            int k = s.nextInt();
            int x = s.nextInt();
            System.out.println(getInitialValue(k, x));
        }
        s.close();
    }

    private static int getInitialValue(int k, int x) {
        int val = x;
        while (k > 0) {
            if (val != 1 && (val - 1) % 3 == 0) {
                val = (val - 1) / 3;
            } else {
                val *= 2;
            }
            k--;
        }
        return val;
    }

}
