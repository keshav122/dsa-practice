package com.codeforces;

import java.util.Scanner;

public class DBMBAndArray_2193A {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while (T-- > 0) {
            int n = s.nextInt();
            int sum = s.nextInt();
            int x = s.nextInt();
            int actualSum = 0;
            for (int i = 0; i < n; i++) {
                actualSum += s.nextInt();
            }
            if (actualSum > sum) {
                System.out.println("NO");
                continue;
            }
            if (actualSum == sum || (sum - actualSum) % x == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        s.close();
    }
}
