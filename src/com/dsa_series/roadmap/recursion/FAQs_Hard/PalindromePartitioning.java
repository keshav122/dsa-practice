package com.dsa_series.roadmap.recursion.FAQs_Hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> li = new ArrayList<>();
        int n = s.length();
        partitionPalindromSubstrings(0, s, res, li, n);
        return res;
    }

    private boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void partitionPalindromSubstrings(int index, String s, List<List<String>> res, List<String> li, int n) {
        if (index == n) {
            res.add(new ArrayList<>(li));
            return;
        }

        for (int j = index; j < n; j++) {
            if (isPalindrome(s, index, j)) {
                li.add(s.substring(index, j + 1));
                partitionPalindromSubstrings(j + 1, s, res, li, n);
                li.remove(li.size() - 1);
            }
        }
    }

}
