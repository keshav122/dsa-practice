package com.cn.guidedpaths.dsa.arrays.mixedproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementII {

	 //Score -40 - TLE
	 public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
		 Map<Integer,Integer> map = new HashMap<>();
         ArrayList<Integer> ans = new ArrayList<>();
         int val = arr.size()/3;
	      for(Integer i : arr){
	    	  if(map.containsKey(i)){
	    		  map.put(i, map.get(i) + 1);
	    	  }else{
	    		 map.put(i, 1); 
	    	  }
	    	  if(map.get(i) > val && !ans.contains(i)){
    			  ans.add(i);
    		  }
	      }
	     

	      return ans;
	  }
	 
	 //Score - 40 - TLE
	 public static ArrayList<Integer> majorityElementII1(ArrayList<Integer> arr) {
		 int ans[] = new int[5001];
		 ArrayList<Integer> a = new ArrayList<>();
		 int val = arr.size()/3;
		 for(Integer i : arr){
			 ans[i]++;
		 }
		 for(int i = 1; i<=ans.length;i++){
			 if(ans[i] > val){
				 a.add(i);
			 }
		 }
		 return a;
	 }
	 
	 //100 - Passed
	 public static ArrayList<Integer> majorityElementII_Official(ArrayList<Integer> arr) {
		 int count1 = 0, count2 = 0;
		 ArrayList<Integer> a = new ArrayList<>();
	     // take the integers as the maximum value of integer hoping the integer
	     // would not be present in the array
	     int first =  Integer.MAX_VALUE;;
	     int second = Integer.MAX_VALUE;
	     int n = arr.size();
	     
	     for (int i = 0; i < n; i++) {
	         // if this element is previously seen, increment count1.
	         if (first == arr.get(i)){
	        	 count1++;
	         }
	             
	         // if this element is previously seen, increment count2.
	         else if (second == arr.get(i)){
	        	 count2++;
	         }
	             
	         else if (count1 == 0) {
	             count1++;
	             first = arr.get(i);
	         }
	  
	         else if (count2 == 0) {
	             count2++;
	             second = arr.get(i);
	         }
	  
	         // if current element is different from both the previously seen
	         // variables, decrement both the counts.
	         else {
	             count1--;
	             count2--;
	         }
	     }
	  
	     count1 = 0;
	     count2 = 0;
	  
	     // Again traverse the array and find the actual counts.
	     for (int i = 0; i < n; i++) {
	         if (arr.get(i) == first){
	        	 count1++;
	         }
	         else if (arr.get(i) == second){
	        	 count2++; 
	         }     
	     }
	  
	     if (count1 > n / 3){
	    	 a.add(first);
	     }
	        
	  
	     if (count2 > n / 3){
	    	 a.add(second);
	     }
	        
	  
	     return a;
	 }
	
	 public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		ArrayList<Integer> ans = majorityElementII(a);
		for(Integer i : ans){
			System.out.print(i+" ");
		}
	}
}
