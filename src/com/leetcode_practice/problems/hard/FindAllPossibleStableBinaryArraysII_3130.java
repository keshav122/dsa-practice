/*Author: keshav122 */
package com.leetcode_practice.problems.hard;

public class FindAllPossibleStableBinaryArraysII_3130 {
    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][][] dp = new long[zero + 1][one + 1][2];
        int MOD = 1_000_000_007;
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        for (int z = 0; z <= zero; z++) {
            for (int o = 0; o <= one; o++) {
                if (z == 0 && o == 0)
                    continue;
                // place 0
                if (z > 0) {
                    if (z == 1 && o == 0) {
                        dp[z][o][0] = 1;
                    } else {
                        long val = (dp[z - 1][o][0] + dp[z - 1][o][1]) % MOD;
                        if (z - limit - 1 >= 0) {
                            val = (val - dp[z - limit - 1][o][1] + MOD) % MOD;
                        }
                        dp[z][o][0] = val;
                    }
                }

                if (o > 0) {
                    if (z == 0 && o == 1) {
                        dp[z][o][1] = 1;
                    } else {
                        long val = (dp[z][o - 1][0] + dp[z][o - 1][1]) % MOD;
                        if (o - limit - 1 >= 0) {
                            val = (val - dp[z][o - limit - 1][0] + MOD) % MOD;
                        }
                        dp[z][o][1] = val;
                    }
                }
            }
        }
        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}
