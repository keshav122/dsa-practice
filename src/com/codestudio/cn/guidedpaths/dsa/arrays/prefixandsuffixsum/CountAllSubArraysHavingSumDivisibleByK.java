/*Author: keshav122 */
package com.codestudio.cn.guidedpaths.dsa.arrays.prefixandsuffixsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountAllSubArraysHavingSumDivisibleByK {

	public static int subArrayCountBruteForce(ArrayList<Integer> arr, int k) {
		int count = 0;
		long temp = 0;
		for (int i = 0; i < arr.size(); i++) {
			
			temp = 0;
			for(int j = i ; j< arr.size();j++){
				temp += arr.get(j);
				if(temp % k == 0){
					count++;
				}
			}
		}
		return count;
	}
	
	//Pepcoding - youtube solution - Score 80 
	public static int subArrayCountPepCoding(ArrayList<Integer> arr, int k) {
		int count = 0;
		
		Map<Integer,Integer> remMap = new HashMap<>();
		remMap.put(0, 1);
		int sum = 0;
		int rem = 0;
		for (int i = 0; i < arr.size(); i++) {
			sum += arr.get(i);
			rem = sum % k;
			if(rem < 0){
				rem += k;
			}
			if(remMap.containsKey(rem)){
				count += remMap.get(rem);
				remMap.put(rem,remMap.get(rem) + 1);
			}else{
				remMap.put(rem,1);
			}
		}
		return count;
	}
	
	//GFG Getting wrong ans
	public static int subArrayCount(ArrayList<Integer> arr, int k) {
		int count = 0;
		int mod[] = new int[k];
		long sum = 0;
		for(int i = 0 ; i<arr.size();i++){
			sum += ((arr.get(i) % k) + k)%k;
			mod[(int) (sum%k)]++;
			
		}
		for(int i = 0; i< k ;i++){
			if(mod[i] > 1){
				count += (mod[i] * (mod[i] -1))/2;
			}
			count += mod[0];
		}
		return count;
	}
	//https://www.youtube.com/watch?v=u9m-hnlcydk -100 score
	public static int subArrayCount_YT(ArrayList<Integer> arr, int k) {
		int count[] = new int[k];
		long sum = 0;
		for(Integer x : arr){
			sum += (x % k + k) % k;
			count[(int) (sum%k)]++;
		}
		
		int result = count[0];
		for(int c : count){
			result += (c * (c-1))/2;
		}
		return result;
	}
}
