package com.dsa_series.roadmap.bit_manipulation;

public class XOROfNumbersInGivenRange {
    // Getting TLE
    public int findRangeXOR_Bf(int l, int r) {
        int ans = l;
        for (int i = l + 1; i <= r; i++) {
            ans ^= i;
        }
        return ans;
    }

    // xor(l to r) = (xor (1 to L-1)) ^ xor(1 to R)
    public int findRangeXOR(int l, int r) {
        return getXOR(l - 1) ^ getXOR(r);
    }

    // This returns the XOR value from 1 to N
    private int getXOR(int n) {
        if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        } else if (n % 4 == 3) {
            return 0;
        } else {
            return n;
        }
    }

}
