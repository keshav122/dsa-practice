package com.leetcode_practice.problems.easy;

import java.util.Arrays;

public class AssignCookies_455 {
      public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int l = 0, r = 0;
            while (l < g.length && r < s.length) {
                  if (s[r] >= g[l]) {
                        l++;
                  }
                  r++;
            }
            return l;
      }
}
