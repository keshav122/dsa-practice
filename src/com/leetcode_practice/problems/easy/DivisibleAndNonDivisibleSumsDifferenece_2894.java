/*Author: keshav122 */
package com.leetcode_practice.problems.easy;

public class DivisibleAndNonDivisibleSumsDifferenece_2894 {
    public int differenceOfSums(int n, int m) {
        int num2 = 0;
        int sum = (n * (n + 1)) / 2;
        if (m <= n) {
            for (int i = m; i <= n; i += m) {
                num2 += i;
            }
        }
        return sum - (2 * num2);
    }

    public int differenceOfSums_optimal(int n, int m) {
        int total = n * (n + 1) / 2;
        // m * (1 + 2 + ... + k) = m * k * (k + 1) / 2
        int k = n / m;
        int num2 = m * k * (k + 1) / 2;
        return total - 2 * num2;
    }
}
