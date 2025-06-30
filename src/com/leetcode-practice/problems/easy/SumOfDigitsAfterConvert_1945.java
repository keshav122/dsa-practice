package com.leetcode-practice.problems.easy;

public class SumOfDigitsAfterConvert_1945 {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append((int) (s.charAt(i) - 'a' + 1));
        }
        String charToNumString = sb.toString();
        int steps = 1;
        while (steps <= k) {
            int sum = 0;
            for (int j = 0; j < charToNumString.length(); j++) {
                sum += (int) charToNumString.charAt(j);
            }
            charToNumString = Integer.toString(sum);
            steps++;
        }
        return Integer.parseInt(charToNumString);
    }
}
