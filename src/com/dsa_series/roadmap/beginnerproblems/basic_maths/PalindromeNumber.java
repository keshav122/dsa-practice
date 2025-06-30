package com.dsa_series.roadmap.beginnerproblems.basic_maths;

public class PalindromeNumber {
    public boolean isPalindrome(int n) {
        int reversedValue = reverseNumber(n);
        return (reversedValue == n);
    }

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
