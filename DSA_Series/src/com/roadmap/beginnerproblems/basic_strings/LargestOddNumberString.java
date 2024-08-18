package com.roadmap.beginnerproblems.basic_strings;

//Not working for Large Test Cases
public class LargestOddNumberString {
    public String largeOddNum(String s) {
        int maxOddValue = Integer.MIN_VALUE;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i; j < s.length(); j++) {
                String subString = s.substring(i, j + 1);
                int value = Integer.parseInt(subString);
                if (value % 2 == 1) {
                    maxOddValue = Math.max(value, maxOddValue);
                }
            }
        }
        if (maxOddValue == Integer.MIN_VALUE) {
            return "";
        }
        return Integer.toString(maxOddValue);
    }
}
