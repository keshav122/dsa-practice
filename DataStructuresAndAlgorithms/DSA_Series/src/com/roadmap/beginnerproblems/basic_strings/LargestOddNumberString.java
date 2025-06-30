package com.roadmap.beginnerproblems.basic_strings;

public class LargestOddNumberString {

    public String largeOddNum(String s) {
        int n = s.length();
        int endIndex = n - 1, i = n - 1;
        while (i >= 0) {
            char c = s.charAt(i);
            boolean isOddCharacter = (c == '1' || c == '3' || c == '5' || c == '7' || c == '9');
            if (isOddCharacter) {
                endIndex = i;
                break;
            }
            i--;
        }

        int startIndex = 0, j = 0;
        while (j <= n - 1) {
            if (s.charAt(j) != '0') {
                startIndex = j;
                break;
            }
            j++;
        }
        return s.substring(startIndex, endIndex + 1);
    }
}
