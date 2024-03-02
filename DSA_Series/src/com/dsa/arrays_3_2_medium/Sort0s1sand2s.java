package com.dsa.arrays_3_2_medium;

import java.util.ArrayList;

public class Sort0s1sand2s {

	//Brute Force
	public static void sortArray(ArrayList<Integer> arr, int n) {
		int zeroCount = 0, oneCount = 0,twoCount = 0;
	      for(Integer i : arr) {
	    	  if(i == 0) {
	    		  zeroCount++;
	    	  }else if(i == 1) {
	    		  oneCount++;
	    	  }else {
	    		  twoCount++;
	    	  }
	      }
	      
	      int j = 0;
	      while(j < zeroCount) {
	    	  arr.set(j, 0);
	    	  j++;
	      }
	      
	      int k = 0;
	      while(k < oneCount) {
	    	  arr.set(j, 1);
	    	  j++;
	          k++;
	      }
	      
	      int l = 0;
	      while(l < twoCount) {
	    	  arr.set(j, 2);
	    	  j++;
	          l++;
	      }
    }
	
	
	
}
