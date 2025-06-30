package com.dsa_series.roadmap.beginnerproblems.basic_maths;

public class ArmstrongNumber {
    public boolean isArmstrong(int n) {
        // We get the number of digits in the number.
        int numberDigits = numberOfDigits(n);
        int input = n;
        int value = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            value += raiseToX(lastDigit, numberDigits);
            n /= 10;
        }
        return (value == input);
    }

    private int raiseToX(int n, int x) {
        int ans = n;
        for (int i = 1; i < x; i++) {
            ans *= n;
        }
        return ans;
    }

    public int numberOfDigits(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 153;
        ArmstrongNumber a = new ArmstrongNumber();
        System.out.println(a.isArmstrong(n));
    }
}
