package com.problems.medium;

public class FindMinimumInRotatedSortedArrays_153 {

    public int findMin_BF(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i : nums) {
        	min = Math.min(i, min);
        }
        return min;
    }
    
    public int findMin_Better(int[] nums) {
        int min = nums[0];
        for(int i = 1; i< nums.length; i++) {
        	min = Math.min(nums[i], min);
        	if(nums[i] < nums[i-1]) {
        		break;
        	}
        }
        return min;
    }
    
    public int findMin_Optimal(int[] nums) {
    	int low = 0;
        int high = nums.length -1;
        int min = Integer.MAX_VALUE;
        while(low <= high) {
     	   int mid = (low + high)/2;
     	   if(nums[mid] < min)   min = nums[mid];
     	   
     	   if(nums[low] <= nums[mid]) {
     		   if(nums[low] < min) {
     			   min = nums[low];
     		   }
     		   low = mid + 1;
     	   }else {
     		   if(nums[mid] < min) {
     			   min = nums[mid];
     		   }
     		   high = mid -1;
     	   }
        }
        return min;
    }
}

