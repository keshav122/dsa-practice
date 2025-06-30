package com.cn.guidedpaths.dsa.arrays.prefixandsuffixsum;

import java.util.ArrayList;
//NR
//Also Asked in Codeforces1132C
//For guidance : https://www.youtube.com/watch?v=4GNUt5unEnM
public class PaintTheFence {
	
	public static int paintTheFence(ArrayList<ArrayList<Integer>> ranges, int n, int q) {
		int countArray[] = new int[n];
		for(ArrayList<Integer> li: ranges){
			for(int i = li.get(0) -1 ; i < li.get(1);i++){
				++countArray[i];
			}
		}
		
		int result = 0;
		for(int i = 0; i< ranges.size();i++){
			int positiveCount = 0;
			int onesArray[] = new int[n];
			for(int j = ranges.get(i).get(0)-1; j<ranges.get(i).get(1);j++){
				--countArray[j];
			}
			
			for(int k = 0; k< n ;k++){
				if(countArray[k] > 0){
					++positiveCount;
				}
				if(countArray[k] == 1){
					++onesArray[k];
				}
			}
			
			//prefix sum on ones
			for(int l = 1; l< n;l++){
				onesArray[l] += onesArray[l-1];
			}
			
			
	        
	        for(int x = i + 1; x < ranges.size(); ++x) {
	            int onesChangedToZeros = getSum(onesArray,ranges.get(x).get(0)-1, ranges.get(x).get(1)-1);
	            result = Integer.max(result, positiveCount - onesChangedToZeros);
	        }
	        
	        // roll back the decreases of countArray
	        for(int y = ranges.get(i).get(0)-1; y <ranges.get(i).get(1); ++y) {
	            ++countArray[y];
	        }
		}
		return result;
	}
	
	private static int getSum(int a[], int leftIndex , int rightIndex){
		if(leftIndex >= 0 ){
			return a[rightIndex] - a[leftIndex];
		}
		return 0;
	}

}
