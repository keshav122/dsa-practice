package com.leetcode_practice.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class FindResultantArrayAfterRemovingAnagrams_2273 {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for (int i = 1; i < n; i++) {
            if (!areAnagrams(words[i], ans.get(ans.size() - 1))) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    private boolean areAnagrams(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;
        }
        for (int x : count) {
            if (x != 0)
                return false;
        }
        return true;

    }
}
