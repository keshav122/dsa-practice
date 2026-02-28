package com.leetcode_practice.problems.medium;

public class ConcatenationOfConsecutiveBinaryNumbers_1680 {

    public int concatenatedBinary_BF(int n) {
        int MOD = 1_000_000_007;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            for (int j = 0; j < s.length(); j++) {
                curr = ((curr << 1) % MOD + (s.charAt(j) - '0')) % MOD;
            }
        }
        return curr;
    }

    public int concatenatedBinary(int n) {
        // Concetation is nothing but shifting by k bits + adding number
        // In decimal also 12 , 34 => 12 * 100 + 34 = 1234
        // In binary if binary(1..(i-1)) = curr => we want to append i to it
        // curr = (curr * (2 ^ k ) + i) , k being the number of bits in k or len of k
        int len = 1;
        int MOD = 1_000_000_007;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & (i - 1)) == 0)
                len++;
            result = ((result * (1 << len) % MOD) % MOD + i) % MOD;
        }
        return (int) result;
    }
}
