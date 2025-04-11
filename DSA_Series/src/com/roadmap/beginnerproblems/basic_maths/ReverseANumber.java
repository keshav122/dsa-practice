package com.roadmap.beginnerproblems.basic_maths;

public class ReverseANumber {
    public int reverseNumber(int n) {
        int reversedValue = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            reversedValue = reversedValue * 10 + lastDigit;
            n /= 10;
        }
        return reversedValue;
    }
}

# Author: keshav122
