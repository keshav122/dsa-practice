package com.codestudio.cn.guidedpaths.dsa.arrays.mixedproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSequence {

	 public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
		 Set<Integer> set = new TreeSet<>();
	      for(int i = 0; i < N ; i++){
	    	  set.add(arr[i]);
	      }
	      List<Integer> li = new ArrayList<>(set);
        
	      int maxCount = 1;
	      int count = 1;
	      int i = 0;
	      while(i< li.size()-1){
	    	  if(li.get(i+1) == li.get(i) + 1){
	    		  count++;
	    	  }else{
	    		  if(count > maxCount){
	    			  maxCount = count;
	    		  }
	    		  count =1;
	    	  }
	    	  i++;
	      }
	      return Math.max(count, maxCount);
	    }
	 
}
