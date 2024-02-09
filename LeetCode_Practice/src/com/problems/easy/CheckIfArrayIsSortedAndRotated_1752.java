package com.problems.easy;


//Note: An array A rotated by x positions results in an array B of the same 
//length such that A[i] == B[(i+x) % A.length],
//where % is the modulo operation.

//Use Case to look at : [2,1,3,4]
public class CheckIfArrayIsSortedAndRotated_1752{

	public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 1; i < n;i++) {
        	if(nums[i] < nums[i-1]) {
        		count++;
        	}
        }
        
        if(nums[n-1] > nums[0]) count++;//There should be max one incident where the higher index element is smaller than
        //lower index element in the circular chain.
       return count<= 1 ? true : false;
    }
}
