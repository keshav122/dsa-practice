package com.leetcode_practice.problems.medium;

public class NextPermutation_31 {

    public void nextPermutation(int[] nums) {
    	int n = nums.length;
        int breakPt = -1;
        for(int i = n-2 ; i >= 0; i--) {
        	if(nums[i] < nums[i+1]) {
        		breakPt = i;
        		
        		break;
        	}
        }
        if(breakPt == -1) {
        	 int start = 0;
             int end = n-1;
             while(start < end) {
            	 int temp = nums[start];
            	 nums[start] =  nums[end];
             	 nums[end] =  temp;
            	 start++;
            	 end--;
             }
        	
        	return;
        }
 
        int breakVal = nums[breakPt];
        for(int i = n-1 ; i >= breakPt; i--) {
        	if(nums[i] >breakVal) {
        		//swap
        		nums[breakPt] =  nums[i];
        		nums[i] =  breakVal;
        		break;
        	}
        }
        
       //reverse breakPt +1  to n-1
        int start = breakPt+1;
        int end = n-1;
        while(start<= end) {
        	int temp = nums[start];
        	nums[start] =  nums[end];
        	nums[end] =  temp;
        	start++;
        	end--;
        }
    }
}
