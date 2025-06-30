package com.dsa_series.roadmap.bit_manipulation;

public class MinimumBitFlipsToConvertNumber {
    // The BruteForce approach would be to convert both the numbers into binary
    // strings and then compare
    // the differences
    public int minBitsFlip_BF(int start, int goal) {
        String startBStr = integerToBinary(start);
        String goalBStr = integerToBinary(goal);

        if (startBStr.length() > goalBStr.length()) {
            return minBitsFlip_BF(goal, start);
        } else {
            int count = 0;
            int i = startBStr.length() - 1;
            int j = goalBStr.length() - 1;
            while (i >= 0) {
                if (startBStr.charAt(i) != goalBStr.charAt(j)) {
                    count++;
                }
                i--;
                j--;
            }

            while (j >= 0) {
                if (goalBStr.charAt(j) == '1') {
                    count++;
                }
                j--;
            }
            return count;
        }
    }

    private String integerToBinary(int n) {
        String res = "";
        while (n != 1) {
            if (n % 2 == 1) {
                res += "1";
            } else {
                res += "0";
            }
            n = n >> 1;
        }
        res += "1";
        // reverse String
        res = reverseString(res);
        return res;
    }

    private String reverseString(String s) {
        String str = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            str += s.charAt(i);
        }
        return str;
    }

    public int minBitsFlip(int start, int goal) {
        // If the bits are same in start & goal then a XOR would result in 0
        // but if they are different , it would result in 1 (those bits would require a
        // flip)
        // So after doing XOR we calculate the set bits in the resultant number
        start = start ^ goal;
        // count of set bits in start
        int count = 0;
        while (start != 1) {
            count += start & 1;// doing a odd check same as if(start % 2 == 1) {count += 1}
            start = start >> 1;
        }
        if (start == 1) {
            count++;
        }
        return count;
    }
}
