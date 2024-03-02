package com.problems.medium;

import java.util.Arrays;

public class SortColors_75 {

	//BruteForceBasic
	public void sortColors_Way1(int[] nums) {
		Arrays.sort(nums);
	}
	public void sortColors(int[] nums) {
		int zeroCount = 0, oneCount = 0,twoCount = 0;
	      for(int i : nums) {
	    	  if(i == 0) {
	    		  zeroCount++;
	    	  }else if(i == 1) {
	    		  oneCount++;
	    	  }else {
	    		  twoCount++;
	    	  }
	      }
	      int i = 0;
	      for(int j = 0;j < zeroCount ; j++) {
	    	  nums[i] = 0;
	    	  i++;
	      }
	      
	      for(int k= 0;k < oneCount ; k++) {
	    	  nums[i] = 1;
	    	  i++;
	      }
	      
	      for(int l= 0;l < twoCount ; l++) {
	    	  nums[i] = 2;
	    	  i++;
	      }
	     
	}
	
	
	
	public static void main(String[] args) {
		SortColors_75 s = new SortColors_75();
		int nums[] = {2,0,2,1,1,0};
		s.sortColors(nums);
		for(int i : nums) {
			System.out.print(i+" ");
		}
	}
}
