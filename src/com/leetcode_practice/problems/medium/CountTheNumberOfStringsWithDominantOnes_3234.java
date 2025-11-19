package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class CountTheNumberOfStringsWithDominantOnes_3234 {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int total = 0;
        for (int i = 0; i < n; i++) {
            int zC = 0, oC = 0;
            if (s.charAt(i) == '0') {
                zC++;
            } else {
                oC++;
                total++;
            }

            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == '0') {
                    zC++;
                } else {
                    oC++;
                }
                if (oC >= zC * zC) {
                    total++;
                }
            }
        }
        return total;
    }

    public int numberOfSubstrings_better(String s) {
        int n = s.length();
        int total = 0;
        int limit = (int) Math.sqrt(n);
        for (int i = 0; i < n; i++) {
            int zero = 0, one = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '0') {
                    zero++;
                } else {
                    one++;
                }

                if (zero > limit)
                    break;
                if (one >= zero * zero) {
                    total++;
                }
            }
        }
        return total;
    }

    public int numberOfSubstrings_optimal(String s) {
        int n = s.length();
        long total = 0;

        // Collect postion of all zeroes
        List<Integer> zeroes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroes.add(i);
            }
        }
        int limit = (int) Math.sqrt(n);
        // For ech starting l
        for (int l = 0; l < n; l++) {
            // Find first zero greater than l
            int firstZero = lowerBound(zeroes, l);

            // Substring starting at l that contain no ZERO
            // These are all ones -> dominant ones
            int endPureOnes = (firstZero == zeroes.size()) ? n - 1 : zeroes.get(firstZero) - 1;
            if (endPureOnes >= l) {
                total += (endPureOnes - l + 1);
            }

            // C - handle substrings with zeroes (at most limit)
            int zeroCount = 0;
            int index = firstZero;
            while (index < zeroes.size() && zeroCount < limit) {
                int zK = zeroes.get(index);// rightmost zero Position
                zeroCount++; // total zeroes = zeroCount

                // We need ones >= (zeroCount)^2
                // ones = (r - l + 1 - zeroCount)
                // solve : r >= l + zeroCount ^ 2 + zeroCount - 1

                int minR = l + zeroCount * zeroCount + zeroCount - 1;

                // r >= zK(substring must contain zK)
                int rStart = Math.max(zK, minR);

                if (rStart < n) {
                    // r can go up to Just Before the nextZero
                    int nextZero = (index + 1 < zeroes.size()) ? zeroes.get(index + 1) : n;
                    int rEnd = nextZero - 1;

                    if (rStart <= rEnd) {
                        total += (rEnd - rStart + 1);
                    }
                }
                index++;
            }

        }
        return (int) total;
    }

    // Binary Search : first index i where arr[i] >= x
    private int lowerBound(List<Integer> zeroes, int x) {
        int low = 0, high = zeroes.size();
        while (low < high) {
            // >>> means unsigned right shift operator
            int mid = (low + high) >>> 1;
            if (zeroes.get(mid) < x)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

}
