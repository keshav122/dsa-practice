package com.dsa.basic_1_6.basic_hashing;

public class CountingFrequenciesOfArrayElements {

	public static int[] countFrequency(int n, int x, int []nums){
        int ans[] = new int[n];
        for(int i : nums) {
        	if(i <= n) {
        		ans[i-1]++;
        	}
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int n = 7;
		int x = 20;
		int nums[] = {10 ,7 ,9 ,8, 14, 20, 6}; 
         int a[] = countFrequency(n, x, nums);
         for(int i : a) {
 			System.out.print(i+" ");
 		}
		
	}
}
