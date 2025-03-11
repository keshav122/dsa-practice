package com.problems.medium;

public class NumberofSubstringsContainingAllThreeCharacters_1358 {

    public int numberOfSubstrings(String s) {
        int l = 0, r = 0, n = s.length();
        int[] charArr = new int[3];
        int count = 0;
        while (r < n) {
            char c = s.charAt(r);
            charArr[c - 'a']++;
            if (charArr[0] > 0 && charArr[1] > 0 && charArr[2] > 0) {
                count += n - r;
            }
            while (l < r && charArr[0] > 0 && charArr[1] > 0 && charArr[2] > 0) {
                char startChar = s.charAt(l);
                charArr[startChar - 'a']--;
                if (charArr[0] > 0 && charArr[1] > 0 && charArr[2] > 0) {
                    count += n - r;
                }
                l++;
            }
            r++;
        }
        return count;
    }
}