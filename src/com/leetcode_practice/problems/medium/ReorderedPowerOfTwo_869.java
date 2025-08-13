package com.leetcode_practice.problems.medium;

import java.util.HashSet;
import java.util.Set;

public class ReorderedPowerOfTwo_869 {
    public boolean reorderedPowerOf2(int n) {
        if (n < 0)
            return false;

        long curr = 2;
        Set<String> digitSignature = new HashSet<>();
        digitSignature.add(digitSign(1));
        digitSignature.add(digitSign(2));
        for (int i = 2; i < 32; i++) {
            curr = curr << 1;
            digitSignature.add(digitSign(curr));
        }
        String inputOcc = digitSign(n);
        if (digitSignature.contains(inputOcc)) {
            return true;
        }
        return false;
    }

    public String digitSign(long n) {
        int[] occArr = new int[10];
        while (n > 0) {
            int lastDigit = (int) (n % 10);
            occArr[lastDigit]++;
            n /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int occ : occArr) {
            sb.append(occ);
        }
        return sb.toString();
    }
}
