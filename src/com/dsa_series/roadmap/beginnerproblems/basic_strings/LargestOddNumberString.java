package com.dsa_series.roadmap.beginnerproblems.basic_strings;

import java.util.Set;

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

    public String largeOddNum_1(String s) {
        int n = s.length();
        int sIndex = 0, eIndex = n - 1;
        Set<Character> odd = Set.of('1', '3', '5', '7', '9');
        while (sIndex < n && s.charAt(sIndex) == '0') {
            sIndex++;
        }

        while (eIndex >= 0 && !odd.contains(s.charAt(eIndex))) {
            eIndex--;
        }
        if (sIndex > eIndex)
            return "";
        return s.substring(sIndex, eIndex + 1);
    }

    public String largeOddNum_1_better(String s) {
        int n = s.length();
        int sIndex = 0, eIndex = n - 1;
        while (sIndex < n && s.charAt(sIndex) == '0') {
            sIndex++;
        }

        while (eIndex >= 0 && (s.charAt(eIndex) - '0') % 2 == 0) {
            eIndex--;
        }
        if (sIndex > eIndex)
            return "";
        return s.substring(sIndex, eIndex + 1);
    }
}
