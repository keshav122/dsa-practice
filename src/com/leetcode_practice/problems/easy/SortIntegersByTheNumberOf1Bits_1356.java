package com.leetcode_practice.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortIntegersByTheNumberOf1Bits_1356 {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        List<Pair> list = new ArrayList<>();
        for (int a : arr) {
            int ones = getOnesCount(a);
            list.add(new Pair(a, ones));
        }
        list.sort(
                Comparator.comparingInt((Pair a) -> a.second)
                        .thenComparingInt(a -> a.first));
        int[] ans = new int[n];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = list.get(i).first;
        }
        return ans;
    }

    private int getOnesCount(int x) {
        String s = Integer.toBinaryString(x);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[] sortByBits_cleaner(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, (a, b) -> {
            int bitCompare = Integer.bitCount(a) - Integer.bitCount(b);
            if (bitCompare != 0)
                return bitCompare;
            return a - b;
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }
}

// Gets the count of 1 bit in a given number
class GetOnesCount {

    private int getOnesCount_native(int x) {
        return Integer.bitCount(x);
    }

    // Brian Kernighan’s Algorithm - Classic Bit Trick
    private int getOnesCount_bit(int x) {
        int count = 0;
        while (x != 0) {
            x = x & (x - 1); // removes lowest set bit
            count++;
        }
        return count;
    }

    private int getOnesCount_bitShift(int x) {
        int count = 0;
        while (x > 0) {
            count += (x & 1);// keeps only the last bit and zeroes everything else
            x >>= 1;
        }
        return count;
    }
}
