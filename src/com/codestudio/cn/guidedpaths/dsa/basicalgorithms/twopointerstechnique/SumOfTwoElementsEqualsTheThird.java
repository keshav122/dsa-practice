/*Author: keshav122 */
package com.codestudio.cn.guidedpaths.dsa.basicalgorithms.twopointerstechnique;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfTwoElementsEqualsTheThird {

	public static ArrayList<Integer> findTripletsBruteForce(int[] arr, int n) {
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					boolean isEqual = (arr[i] + arr[j] == arr[k]) || (arr[i] + arr[k] == arr[j])
							|| (arr[j] + arr[k] == arr[i]);
					if(isEqual){
						ans.add(arr[i]);
						ans.add(arr[j]);
						ans.add(arr[k]);
						return ans;
					}

				}
			}
		}
		return ans;

	}
	
	public static ArrayList<Integer> findTripletsOptimized(int[] arr, int n) {
		Arrays.sort(arr);
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n - 2; i++) {
			int j = i+1, k = n-1;
			while(j < k){
				int temp = arr[k] - arr[j];
				System.out.println("Value :" + arr[i] + " : "+arr[j]+ " : "+arr[k]);
				if(temp == arr[i]){
					ans.add(arr[i]);
					ans.add(arr[j]);
					ans.add(arr[k]);
					return ans;
				}else if( temp > arr[i]){
					k--;
				}else{
					break;
				}
			}
		}
		
		return ans;

	}
	
	public static void main(String[] args) {
		int a[] = {36,6,15,12,18,49,16};
		int n = 7;
		System.out.println(findTripletsOptimized(a, n).size());
	}
}
