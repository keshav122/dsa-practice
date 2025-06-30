package com.dsa_series.roadmap.beginnerproblems.basic_recursion;

public class CheckPrime {
    public boolean checkPrime(int num) {
        return checkPrime(num, 2);
    }

    private boolean checkPrime(int num, int divisor) {
        if (num <= 2) {
            return (num == 2) ? true : false;
        }
        if (num % divisor == 0) {
            return false;
        }

        if (divisor * divisor > num) {
            return true;
        }
        return checkPrime(num, divisor + 1);
    }

    public static void main(String[] args) {
        int num = 5;
        CheckPrime c = new CheckPrime();
        System.out.println(c.checkPrime(num));
    }
}
