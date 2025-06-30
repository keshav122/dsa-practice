/*Author: keshav122 */
package com.cn.guidedpaths.dsa.arrays.mixedproblems;

import java.util.ArrayList;

public class PrintTheArrayAfterKOperations {

	public static ArrayList<Integer> printArrayAfterKOperations(ArrayList<Integer> arr, int n, int k) {
	  int maxVal = Integer.MIN_VALUE;
	  int minVal = Integer.MAX_VALUE;
	  for(Integer i : arr){
			maxVal = Math.max(maxVal, i);
			minVal = Math.min(minVal, i);
		}
		if(k != 0){
			if(k % 2 == 1){
				for(int i= 0; i< arr.size();i++){
					arr.set(i, maxVal - arr.get(i));
				}
			}else{
				for(int i= 0; i< arr.size();i++){
					arr.set(i, arr.get(i) - minVal);
				}
			}
		}
		return arr;
	}

	
}

# Author: keshav122
