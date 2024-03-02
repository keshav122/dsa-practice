package com.dsa.arrays_3_2_medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSuccessiveElements {
	
	public static int longestSuccessiveElements(int[] a) {
		 Set<Integer> set = new HashSet<>();
		    for(int n : a) {
		    	set.add(n);
		    }
		    Integer[] resArray = set.toArray(new Integer[set.size()]);
		    Arrays.sort(resArray);
			int n = resArray.length;
			int maxLen = 1, sI = 0;
			boolean isContinous = true;
			for (int i = 1; i < n; i++) {
				if (resArray[i] - resArray[i - 1] != 1) {
					sI = i;
					isContinous = false;
				}else {
					maxLen = Math.max(maxLen, i - sI + 1);
				}
			}
			if (isContinous)
				maxLen = n;
			return maxLen;
	}
	
	public static int longestSuccessiveElements_Way1(int[] a) {
		Set<Integer> set = new HashSet<>();
	    for(int n : a) {
	    	set.add(n);
	    }
	    int n = a.length;
	    int answer = 0;
	    for (int i = 0; i < n; i++) {
	    	if(!set.contains(a[i] - 1)) {
	    		int curElem = a[i];
	    		while(set.contains(curElem + 1)) {
	    			curElem++;
	    		}
	    		int curLen = curElem -a[i] + 1;
	    		answer = Math.max(answer, curLen);
	    	}
	    		
	    }
	    return answer;
	}

	public static void main(String[] args) {
		int a[] = { 21, 15, 6, 2, 1, 16, 4, 2, 29, 9, 12, 8, 5, 14, 21, 8, 12, 17, 16, 6, 26, 3 };
		System.out.println(longestSuccessiveElements(a));

	}
}
