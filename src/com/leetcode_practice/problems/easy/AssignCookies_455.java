package com.leetcode_practice.problems.easy;

import java.util.Arrays;

public class AssignCookies_455 {

	public int findContentChildren(int[] g, int[] s) {
      Arrays.sort(g);
      Arrays.sort(s);
      int count = 0;
      int iterationLen = Math.min(g.length, s.length);
      int i = 0;
      int j = 0;
      while(i< iterationLen) {
    	  if(s[j] >= g[i]) {
    		  count++;
    		  i++;
    		  j++;
    	  }else {
    		   j++;
    	  }
      }
      return count;
	}
}
