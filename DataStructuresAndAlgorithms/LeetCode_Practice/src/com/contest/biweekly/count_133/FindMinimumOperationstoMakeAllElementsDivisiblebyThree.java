package com.contest.biweekly.count_133;

public class FindMinimumOperationstoMakeAllElementsDivisiblebyThree {

	public int minimumOperations(int[] nums) {
        int count = 0;
        for(int i : nums){
            if(i % 3 != 0){
                 count++;
            }
        }
        return count;
    }
	

	public static void main(String[] args) {
	
	}
}
