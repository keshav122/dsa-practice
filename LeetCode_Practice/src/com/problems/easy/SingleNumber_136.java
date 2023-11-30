package com.problems.easy;

import java.util.*;

public class SingleNumber_136 {

	public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
           if(map.containsKey(num)) {
        	   map.put(num, 2);
           }else {
        	   map.put(num, 1);
           }  
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if(entry.getValue() == 1) {
        		return entry.getKey();
        	}
        }
        return -1;
    }
	
}
