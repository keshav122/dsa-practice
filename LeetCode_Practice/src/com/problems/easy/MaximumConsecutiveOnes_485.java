package com.problems.easy;

public class MaximumConsecutiveOnes_485 {

	
	 public int findMaxConsecutiveOnes(int[] nums) {
	        int maxSize = 0;
	        int count = 0;
	        for(int i = 0; i < nums.length ;i++) {
	        	if(nums[i] == 1) {
	        		count++;
	        	}else {
	        		maxSize = Math.max(maxSize, count);
	        		count =0;
	        	}
	        }
	        return Math.max(maxSize, count);
	    }
	 
	public static void main(String[] args) {
		

	}

}
