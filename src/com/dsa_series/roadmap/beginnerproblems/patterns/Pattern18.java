/*Author: keshav122 */
package com.dsa_series.roadmap.beginnerproblems.patterns;

public class Pattern18 {
    public void pattern18(int n) {
        for (int i = 1; i <= n; i++) {
            char initialChar = (char) ('A' + (n - i));
            for (int j = 0; j < i; j++) {
                System.out.print((char) (initialChar + j) + " ");
            }
            System.out.println();
        }
    }
}