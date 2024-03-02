package com.dsa.arrays_3_2_medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	 public static int majorityElement(int []v) {
	       Map<Integer,Integer> map = new HashMap<>();
	       int n = (v.length)/2;
	       for(int i : v) {
	    	   map.put(i, map.getOrDefault(i, 0) + 1);
	    	   if(map.get(i) > n) {
	    		   return i;
	    	   }
	       }
	       return v[0];
	    }
	 
	 
	 public static int majorityElement_Way1(int []v) {
		 int count = 1;
		 int majorityElem = v[0];
		 for(int i = 1; i< v.length;i++) {
			 if(v[i] == majorityElem) {
				 count++;
			 }else {
				 count--;
				 if(count == 0) {
					 majorityElem = v[i];
					 count = 1;
				 }
			 }
		 }
		 return majorityElem;
	 }
	 
	 public static void main(String[] args) {
		int v[] = {1,3,1,1,4,1,1,5,1,1,6,2,2};
		System.out.println(majorityElement_Way1(v));
	}
}
